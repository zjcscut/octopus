package org.slf4j;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.google.common.collect.Maps;
import org.slf4j.spi.MDCAdapter;

import java.util.Collections;
import java.util.Map;

/**
 * @author throwable
 * @version v1
 * @description
 * @since 2020/12/27 13:03
 */
public class TransmittableThreadLocalMappedDiagnosticContextAdapter implements MDCAdapter {

    final ThreadLocal<Map<String, String>> copyOnInheritThreadLocal = new TransmittableThreadLocal<>();

    private static final int WRITE_OPERATION = 1;
    private static final int READ_OPERATION = 2;

    final ThreadLocal<Integer> lastOperation = new ThreadLocal<>();

    private static final MDCAdapter ADAPTER;

    static {
        ADAPTER = new TransmittableThreadLocalMappedDiagnosticContextAdapter();
        MDC.mdcAdapter = ADAPTER;
    }

    public static MDCAdapter getInstance() {
        return ADAPTER;
    }

    private Integer getAndSetLastOperation(int op) {
        Integer lastOp = lastOperation.get();
        lastOperation.set(op);
        return lastOp;
    }

    private static boolean wasLastOpReadOrNull(Integer lastOp) {
        return lastOp == null || lastOp == READ_OPERATION;
    }

    private synchronized Map<String, String> duplicateAndInsertNewMap(Map<String, String> oldMap) {
        Map<String, String> newMap = Collections.synchronizedMap(Maps.newHashMap());
        if (oldMap != null) {
            newMap.putAll(oldMap);
        }
        copyOnInheritThreadLocal.set(newMap);
        return newMap;
    }

    @Override
    public void put(String key, String val) {
        if (key == null) {
            throw new IllegalArgumentException("key cannot be null");
        }
        Map<String, String> oldMap = copyOnInheritThreadLocal.get();
        Integer lastOp = getAndSetLastOperation(WRITE_OPERATION);

        if (wasLastOpReadOrNull(lastOp) || oldMap == null) {
            Map<String, String> newMap = duplicateAndInsertNewMap(oldMap);
            newMap.put(key, val);
        } else {
            oldMap.put(key, val);
        }
    }

    @Override
    public void remove(String key) {
        if (key == null) {
            return;
        }
        Map<String, String> oldMap = copyOnInheritThreadLocal.get();
        if (oldMap == null) {
            return;
        }
        Integer lastOp = getAndSetLastOperation(WRITE_OPERATION);
        if (wasLastOpReadOrNull(lastOp)) {
            Map<String, String> newMap = duplicateAndInsertNewMap(oldMap);
            newMap.remove(key);
        } else {
            oldMap.remove(key);
        }
    }

    @Override
    public void clear() {
        lastOperation.set(WRITE_OPERATION);
        copyOnInheritThreadLocal.remove();
    }

    @Override
    public String get(String key) {
        Map<String, String> map = getPropertyMap();
        if ((map != null) && (key != null)) {
            return map.get(key);
        } else {
            return null;
        }
    }

    public Map<String, String> getPropertyMap() {
        lastOperation.set(READ_OPERATION);
        return copyOnInheritThreadLocal.get();
    }

    @Override
    public Map<String, String> getCopyOfContextMap() {
        lastOperation.set(READ_OPERATION);
        Map<String, String> hashMap = copyOnInheritThreadLocal.get();
        if (hashMap == null) {
            return null;
        } else {
            return Maps.newHashMap(hashMap);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setContextMap(Map contextMap) {
        lastOperation.set(WRITE_OPERATION);
        Map<String, String> newMap = Collections.synchronizedMap(Maps.newHashMap());
        newMap.putAll(contextMap);
        copyOnInheritThreadLocal.set(newMap);
    }
}
