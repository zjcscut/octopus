package cn.throwx.octopus.server.model.entity;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransformEventRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TransformEventRecordExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(OffsetDateTime value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(OffsetDateTime value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(OffsetDateTime value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(OffsetDateTime value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(OffsetDateTime value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(OffsetDateTime value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<OffsetDateTime> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<OffsetDateTime> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeIsNull() {
            addCriterion("edit_time is null");
            return (Criteria) this;
        }

        public Criteria andEditTimeIsNotNull() {
            addCriterion("edit_time is not null");
            return (Criteria) this;
        }

        public Criteria andEditTimeEqualTo(OffsetDateTime value) {
            addCriterion("edit_time =", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeNotEqualTo(OffsetDateTime value) {
            addCriterion("edit_time <>", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeGreaterThan(OffsetDateTime value) {
            addCriterion("edit_time >", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeGreaterThanOrEqualTo(OffsetDateTime value) {
            addCriterion("edit_time >=", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeLessThan(OffsetDateTime value) {
            addCriterion("edit_time <", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeLessThanOrEqualTo(OffsetDateTime value) {
            addCriterion("edit_time <=", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeIn(List<OffsetDateTime> values) {
            addCriterion("edit_time in", values, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeNotIn(List<OffsetDateTime> values) {
            addCriterion("edit_time not in", values, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("edit_time between", value1, value2, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeNotBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("edit_time not between", value1, value2, "editTime");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andEditorIsNull() {
            addCriterion("editor is null");
            return (Criteria) this;
        }

        public Criteria andEditorIsNotNull() {
            addCriterion("editor is not null");
            return (Criteria) this;
        }

        public Criteria andEditorEqualTo(String value) {
            addCriterion("editor =", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorNotEqualTo(String value) {
            addCriterion("editor <>", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorGreaterThan(String value) {
            addCriterion("editor >", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorGreaterThanOrEqualTo(String value) {
            addCriterion("editor >=", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorLessThan(String value) {
            addCriterion("editor <", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorLessThanOrEqualTo(String value) {
            addCriterion("editor <=", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorLike(String value) {
            addCriterion("editor like", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorNotLike(String value) {
            addCriterion("editor not like", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorIn(List<String> values) {
            addCriterion("editor in", values, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorNotIn(List<String> values) {
            addCriterion("editor not in", values, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorBetween(String value1, String value2) {
            addCriterion("editor between", value1, value2, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorNotBetween(String value1, String value2) {
            addCriterion("editor not between", value1, value2, "editor");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(Integer value) {
            addCriterion("deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(Integer value) {
            addCriterion("deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(Integer value) {
            addCriterion("deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(Integer value) {
            addCriterion("deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(Integer value) {
            addCriterion("deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(Integer value) {
            addCriterion("deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<Integer> values) {
            addCriterion("deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<Integer> values) {
            addCriterion("deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(Integer value1, Integer value2) {
            addCriterion("deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(Integer value1, Integer value2) {
            addCriterion("deleted not between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Long value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Long value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Long value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Long value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Long value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Long value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Long> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Long> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Long value1, Long value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Long value1, Long value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andUniqueIdentityIsNull() {
            addCriterion("unique_identity is null");
            return (Criteria) this;
        }

        public Criteria andUniqueIdentityIsNotNull() {
            addCriterion("unique_identity is not null");
            return (Criteria) this;
        }

        public Criteria andUniqueIdentityEqualTo(String value) {
            addCriterion("unique_identity =", value, "uniqueIdentity");
            return (Criteria) this;
        }

        public Criteria andUniqueIdentityNotEqualTo(String value) {
            addCriterion("unique_identity <>", value, "uniqueIdentity");
            return (Criteria) this;
        }

        public Criteria andUniqueIdentityGreaterThan(String value) {
            addCriterion("unique_identity >", value, "uniqueIdentity");
            return (Criteria) this;
        }

        public Criteria andUniqueIdentityGreaterThanOrEqualTo(String value) {
            addCriterion("unique_identity >=", value, "uniqueIdentity");
            return (Criteria) this;
        }

        public Criteria andUniqueIdentityLessThan(String value) {
            addCriterion("unique_identity <", value, "uniqueIdentity");
            return (Criteria) this;
        }

        public Criteria andUniqueIdentityLessThanOrEqualTo(String value) {
            addCriterion("unique_identity <=", value, "uniqueIdentity");
            return (Criteria) this;
        }

        public Criteria andUniqueIdentityLike(String value) {
            addCriterion("unique_identity like", value, "uniqueIdentity");
            return (Criteria) this;
        }

        public Criteria andUniqueIdentityNotLike(String value) {
            addCriterion("unique_identity not like", value, "uniqueIdentity");
            return (Criteria) this;
        }

        public Criteria andUniqueIdentityIn(List<String> values) {
            addCriterion("unique_identity in", values, "uniqueIdentity");
            return (Criteria) this;
        }

        public Criteria andUniqueIdentityNotIn(List<String> values) {
            addCriterion("unique_identity not in", values, "uniqueIdentity");
            return (Criteria) this;
        }

        public Criteria andUniqueIdentityBetween(String value1, String value2) {
            addCriterion("unique_identity between", value1, value2, "uniqueIdentity");
            return (Criteria) this;
        }

        public Criteria andUniqueIdentityNotBetween(String value1, String value2) {
            addCriterion("unique_identity not between", value1, value2, "uniqueIdentity");
            return (Criteria) this;
        }

        public Criteria andClientIpIsNull() {
            addCriterion("client_ip is null");
            return (Criteria) this;
        }

        public Criteria andClientIpIsNotNull() {
            addCriterion("client_ip is not null");
            return (Criteria) this;
        }

        public Criteria andClientIpEqualTo(String value) {
            addCriterion("client_ip =", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpNotEqualTo(String value) {
            addCriterion("client_ip <>", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpGreaterThan(String value) {
            addCriterion("client_ip >", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpGreaterThanOrEqualTo(String value) {
            addCriterion("client_ip >=", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpLessThan(String value) {
            addCriterion("client_ip <", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpLessThanOrEqualTo(String value) {
            addCriterion("client_ip <=", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpLike(String value) {
            addCriterion("client_ip like", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpNotLike(String value) {
            addCriterion("client_ip not like", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpIn(List<String> values) {
            addCriterion("client_ip in", values, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpNotIn(List<String> values) {
            addCriterion("client_ip not in", values, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpBetween(String value1, String value2) {
            addCriterion("client_ip between", value1, value2, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpNotBetween(String value1, String value2) {
            addCriterion("client_ip not between", value1, value2, "clientIp");
            return (Criteria) this;
        }

        public Criteria andShortUrlIsNull() {
            addCriterion("short_url is null");
            return (Criteria) this;
        }

        public Criteria andShortUrlIsNotNull() {
            addCriterion("short_url is not null");
            return (Criteria) this;
        }

        public Criteria andShortUrlEqualTo(String value) {
            addCriterion("short_url =", value, "shortUrl");
            return (Criteria) this;
        }

        public Criteria andShortUrlNotEqualTo(String value) {
            addCriterion("short_url <>", value, "shortUrl");
            return (Criteria) this;
        }

        public Criteria andShortUrlGreaterThan(String value) {
            addCriterion("short_url >", value, "shortUrl");
            return (Criteria) this;
        }

        public Criteria andShortUrlGreaterThanOrEqualTo(String value) {
            addCriterion("short_url >=", value, "shortUrl");
            return (Criteria) this;
        }

        public Criteria andShortUrlLessThan(String value) {
            addCriterion("short_url <", value, "shortUrl");
            return (Criteria) this;
        }

        public Criteria andShortUrlLessThanOrEqualTo(String value) {
            addCriterion("short_url <=", value, "shortUrl");
            return (Criteria) this;
        }

        public Criteria andShortUrlLike(String value) {
            addCriterion("short_url like", value, "shortUrl");
            return (Criteria) this;
        }

        public Criteria andShortUrlNotLike(String value) {
            addCriterion("short_url not like", value, "shortUrl");
            return (Criteria) this;
        }

        public Criteria andShortUrlIn(List<String> values) {
            addCriterion("short_url in", values, "shortUrl");
            return (Criteria) this;
        }

        public Criteria andShortUrlNotIn(List<String> values) {
            addCriterion("short_url not in", values, "shortUrl");
            return (Criteria) this;
        }

        public Criteria andShortUrlBetween(String value1, String value2) {
            addCriterion("short_url between", value1, value2, "shortUrl");
            return (Criteria) this;
        }

        public Criteria andShortUrlNotBetween(String value1, String value2) {
            addCriterion("short_url not between", value1, value2, "shortUrl");
            return (Criteria) this;
        }

        public Criteria andLongUrlIsNull() {
            addCriterion("long_url is null");
            return (Criteria) this;
        }

        public Criteria andLongUrlIsNotNull() {
            addCriterion("long_url is not null");
            return (Criteria) this;
        }

        public Criteria andLongUrlEqualTo(String value) {
            addCriterion("long_url =", value, "longUrl");
            return (Criteria) this;
        }

        public Criteria andLongUrlNotEqualTo(String value) {
            addCriterion("long_url <>", value, "longUrl");
            return (Criteria) this;
        }

        public Criteria andLongUrlGreaterThan(String value) {
            addCriterion("long_url >", value, "longUrl");
            return (Criteria) this;
        }

        public Criteria andLongUrlGreaterThanOrEqualTo(String value) {
            addCriterion("long_url >=", value, "longUrl");
            return (Criteria) this;
        }

        public Criteria andLongUrlLessThan(String value) {
            addCriterion("long_url <", value, "longUrl");
            return (Criteria) this;
        }

        public Criteria andLongUrlLessThanOrEqualTo(String value) {
            addCriterion("long_url <=", value, "longUrl");
            return (Criteria) this;
        }

        public Criteria andLongUrlLike(String value) {
            addCriterion("long_url like", value, "longUrl");
            return (Criteria) this;
        }

        public Criteria andLongUrlNotLike(String value) {
            addCriterion("long_url not like", value, "longUrl");
            return (Criteria) this;
        }

        public Criteria andLongUrlIn(List<String> values) {
            addCriterion("long_url in", values, "longUrl");
            return (Criteria) this;
        }

        public Criteria andLongUrlNotIn(List<String> values) {
            addCriterion("long_url not in", values, "longUrl");
            return (Criteria) this;
        }

        public Criteria andLongUrlBetween(String value1, String value2) {
            addCriterion("long_url between", value1, value2, "longUrl");
            return (Criteria) this;
        }

        public Criteria andLongUrlNotBetween(String value1, String value2) {
            addCriterion("long_url not between", value1, value2, "longUrl");
            return (Criteria) this;
        }

        public Criteria andShortUrlDigestIsNull() {
            addCriterion("short_url_digest is null");
            return (Criteria) this;
        }

        public Criteria andShortUrlDigestIsNotNull() {
            addCriterion("short_url_digest is not null");
            return (Criteria) this;
        }

        public Criteria andShortUrlDigestEqualTo(String value) {
            addCriterion("short_url_digest =", value, "shortUrlDigest");
            return (Criteria) this;
        }

        public Criteria andShortUrlDigestNotEqualTo(String value) {
            addCriterion("short_url_digest <>", value, "shortUrlDigest");
            return (Criteria) this;
        }

        public Criteria andShortUrlDigestGreaterThan(String value) {
            addCriterion("short_url_digest >", value, "shortUrlDigest");
            return (Criteria) this;
        }

        public Criteria andShortUrlDigestGreaterThanOrEqualTo(String value) {
            addCriterion("short_url_digest >=", value, "shortUrlDigest");
            return (Criteria) this;
        }

        public Criteria andShortUrlDigestLessThan(String value) {
            addCriterion("short_url_digest <", value, "shortUrlDigest");
            return (Criteria) this;
        }

        public Criteria andShortUrlDigestLessThanOrEqualTo(String value) {
            addCriterion("short_url_digest <=", value, "shortUrlDigest");
            return (Criteria) this;
        }

        public Criteria andShortUrlDigestLike(String value) {
            addCriterion("short_url_digest like", value, "shortUrlDigest");
            return (Criteria) this;
        }

        public Criteria andShortUrlDigestNotLike(String value) {
            addCriterion("short_url_digest not like", value, "shortUrlDigest");
            return (Criteria) this;
        }

        public Criteria andShortUrlDigestIn(List<String> values) {
            addCriterion("short_url_digest in", values, "shortUrlDigest");
            return (Criteria) this;
        }

        public Criteria andShortUrlDigestNotIn(List<String> values) {
            addCriterion("short_url_digest not in", values, "shortUrlDigest");
            return (Criteria) this;
        }

        public Criteria andShortUrlDigestBetween(String value1, String value2) {
            addCriterion("short_url_digest between", value1, value2, "shortUrlDigest");
            return (Criteria) this;
        }

        public Criteria andShortUrlDigestNotBetween(String value1, String value2) {
            addCriterion("short_url_digest not between", value1, value2, "shortUrlDigest");
            return (Criteria) this;
        }

        public Criteria andLongUrlDigestIsNull() {
            addCriterion("long_url_digest is null");
            return (Criteria) this;
        }

        public Criteria andLongUrlDigestIsNotNull() {
            addCriterion("long_url_digest is not null");
            return (Criteria) this;
        }

        public Criteria andLongUrlDigestEqualTo(String value) {
            addCriterion("long_url_digest =", value, "longUrlDigest");
            return (Criteria) this;
        }

        public Criteria andLongUrlDigestNotEqualTo(String value) {
            addCriterion("long_url_digest <>", value, "longUrlDigest");
            return (Criteria) this;
        }

        public Criteria andLongUrlDigestGreaterThan(String value) {
            addCriterion("long_url_digest >", value, "longUrlDigest");
            return (Criteria) this;
        }

        public Criteria andLongUrlDigestGreaterThanOrEqualTo(String value) {
            addCriterion("long_url_digest >=", value, "longUrlDigest");
            return (Criteria) this;
        }

        public Criteria andLongUrlDigestLessThan(String value) {
            addCriterion("long_url_digest <", value, "longUrlDigest");
            return (Criteria) this;
        }

        public Criteria andLongUrlDigestLessThanOrEqualTo(String value) {
            addCriterion("long_url_digest <=", value, "longUrlDigest");
            return (Criteria) this;
        }

        public Criteria andLongUrlDigestLike(String value) {
            addCriterion("long_url_digest like", value, "longUrlDigest");
            return (Criteria) this;
        }

        public Criteria andLongUrlDigestNotLike(String value) {
            addCriterion("long_url_digest not like", value, "longUrlDigest");
            return (Criteria) this;
        }

        public Criteria andLongUrlDigestIn(List<String> values) {
            addCriterion("long_url_digest in", values, "longUrlDigest");
            return (Criteria) this;
        }

        public Criteria andLongUrlDigestNotIn(List<String> values) {
            addCriterion("long_url_digest not in", values, "longUrlDigest");
            return (Criteria) this;
        }

        public Criteria andLongUrlDigestBetween(String value1, String value2) {
            addCriterion("long_url_digest between", value1, value2, "longUrlDigest");
            return (Criteria) this;
        }

        public Criteria andLongUrlDigestNotBetween(String value1, String value2) {
            addCriterion("long_url_digest not between", value1, value2, "longUrlDigest");
            return (Criteria) this;
        }

        public Criteria andCompressionCodeIsNull() {
            addCriterion("compression_code is null");
            return (Criteria) this;
        }

        public Criteria andCompressionCodeIsNotNull() {
            addCriterion("compression_code is not null");
            return (Criteria) this;
        }

        public Criteria andCompressionCodeEqualTo(String value) {
            addCriterion("compression_code =", value, "compressionCode");
            return (Criteria) this;
        }

        public Criteria andCompressionCodeNotEqualTo(String value) {
            addCriterion("compression_code <>", value, "compressionCode");
            return (Criteria) this;
        }

        public Criteria andCompressionCodeGreaterThan(String value) {
            addCriterion("compression_code >", value, "compressionCode");
            return (Criteria) this;
        }

        public Criteria andCompressionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("compression_code >=", value, "compressionCode");
            return (Criteria) this;
        }

        public Criteria andCompressionCodeLessThan(String value) {
            addCriterion("compression_code <", value, "compressionCode");
            return (Criteria) this;
        }

        public Criteria andCompressionCodeLessThanOrEqualTo(String value) {
            addCriterion("compression_code <=", value, "compressionCode");
            return (Criteria) this;
        }

        public Criteria andCompressionCodeLike(String value) {
            addCriterion("compression_code like", value, "compressionCode");
            return (Criteria) this;
        }

        public Criteria andCompressionCodeNotLike(String value) {
            addCriterion("compression_code not like", value, "compressionCode");
            return (Criteria) this;
        }

        public Criteria andCompressionCodeIn(List<String> values) {
            addCriterion("compression_code in", values, "compressionCode");
            return (Criteria) this;
        }

        public Criteria andCompressionCodeNotIn(List<String> values) {
            addCriterion("compression_code not in", values, "compressionCode");
            return (Criteria) this;
        }

        public Criteria andCompressionCodeBetween(String value1, String value2) {
            addCriterion("compression_code between", value1, value2, "compressionCode");
            return (Criteria) this;
        }

        public Criteria andCompressionCodeNotBetween(String value1, String value2) {
            addCriterion("compression_code not between", value1, value2, "compressionCode");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIsNull() {
            addCriterion("record_time is null");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIsNotNull() {
            addCriterion("record_time is not null");
            return (Criteria) this;
        }

        public Criteria andRecordTimeEqualTo(OffsetDateTime value) {
            addCriterion("record_time =", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotEqualTo(OffsetDateTime value) {
            addCriterion("record_time <>", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeGreaterThan(OffsetDateTime value) {
            addCriterion("record_time >", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeGreaterThanOrEqualTo(OffsetDateTime value) {
            addCriterion("record_time >=", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeLessThan(OffsetDateTime value) {
            addCriterion("record_time <", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeLessThanOrEqualTo(OffsetDateTime value) {
            addCriterion("record_time <=", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIn(List<OffsetDateTime> values) {
            addCriterion("record_time in", values, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotIn(List<OffsetDateTime> values) {
            addCriterion("record_time not in", values, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("record_time between", value1, value2, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("record_time not between", value1, value2, "recordTime");
            return (Criteria) this;
        }

        public Criteria andUserAgentIsNull() {
            addCriterion("user_agent is null");
            return (Criteria) this;
        }

        public Criteria andUserAgentIsNotNull() {
            addCriterion("user_agent is not null");
            return (Criteria) this;
        }

        public Criteria andUserAgentEqualTo(String value) {
            addCriterion("user_agent =", value, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentNotEqualTo(String value) {
            addCriterion("user_agent <>", value, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentGreaterThan(String value) {
            addCriterion("user_agent >", value, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentGreaterThanOrEqualTo(String value) {
            addCriterion("user_agent >=", value, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentLessThan(String value) {
            addCriterion("user_agent <", value, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentLessThanOrEqualTo(String value) {
            addCriterion("user_agent <=", value, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentLike(String value) {
            addCriterion("user_agent like", value, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentNotLike(String value) {
            addCriterion("user_agent not like", value, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentIn(List<String> values) {
            addCriterion("user_agent in", values, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentNotIn(List<String> values) {
            addCriterion("user_agent not in", values, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentBetween(String value1, String value2) {
            addCriterion("user_agent between", value1, value2, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentNotBetween(String value1, String value2) {
            addCriterion("user_agent not between", value1, value2, "userAgent");
            return (Criteria) this;
        }

        public Criteria andCookieValueIsNull() {
            addCriterion("cookie_value is null");
            return (Criteria) this;
        }

        public Criteria andCookieValueIsNotNull() {
            addCriterion("cookie_value is not null");
            return (Criteria) this;
        }

        public Criteria andCookieValueEqualTo(String value) {
            addCriterion("cookie_value =", value, "cookieValue");
            return (Criteria) this;
        }

        public Criteria andCookieValueNotEqualTo(String value) {
            addCriterion("cookie_value <>", value, "cookieValue");
            return (Criteria) this;
        }

        public Criteria andCookieValueGreaterThan(String value) {
            addCriterion("cookie_value >", value, "cookieValue");
            return (Criteria) this;
        }

        public Criteria andCookieValueGreaterThanOrEqualTo(String value) {
            addCriterion("cookie_value >=", value, "cookieValue");
            return (Criteria) this;
        }

        public Criteria andCookieValueLessThan(String value) {
            addCriterion("cookie_value <", value, "cookieValue");
            return (Criteria) this;
        }

        public Criteria andCookieValueLessThanOrEqualTo(String value) {
            addCriterion("cookie_value <=", value, "cookieValue");
            return (Criteria) this;
        }

        public Criteria andCookieValueLike(String value) {
            addCriterion("cookie_value like", value, "cookieValue");
            return (Criteria) this;
        }

        public Criteria andCookieValueNotLike(String value) {
            addCriterion("cookie_value not like", value, "cookieValue");
            return (Criteria) this;
        }

        public Criteria andCookieValueIn(List<String> values) {
            addCriterion("cookie_value in", values, "cookieValue");
            return (Criteria) this;
        }

        public Criteria andCookieValueNotIn(List<String> values) {
            addCriterion("cookie_value not in", values, "cookieValue");
            return (Criteria) this;
        }

        public Criteria andCookieValueBetween(String value1, String value2) {
            addCriterion("cookie_value between", value1, value2, "cookieValue");
            return (Criteria) this;
        }

        public Criteria andCookieValueNotBetween(String value1, String value2) {
            addCriterion("cookie_value not between", value1, value2, "cookieValue");
            return (Criteria) this;
        }

        public Criteria andQueryParamIsNull() {
            addCriterion("query_param is null");
            return (Criteria) this;
        }

        public Criteria andQueryParamIsNotNull() {
            addCriterion("query_param is not null");
            return (Criteria) this;
        }

        public Criteria andQueryParamEqualTo(String value) {
            addCriterion("query_param =", value, "queryParam");
            return (Criteria) this;
        }

        public Criteria andQueryParamNotEqualTo(String value) {
            addCriterion("query_param <>", value, "queryParam");
            return (Criteria) this;
        }

        public Criteria andQueryParamGreaterThan(String value) {
            addCriterion("query_param >", value, "queryParam");
            return (Criteria) this;
        }

        public Criteria andQueryParamGreaterThanOrEqualTo(String value) {
            addCriterion("query_param >=", value, "queryParam");
            return (Criteria) this;
        }

        public Criteria andQueryParamLessThan(String value) {
            addCriterion("query_param <", value, "queryParam");
            return (Criteria) this;
        }

        public Criteria andQueryParamLessThanOrEqualTo(String value) {
            addCriterion("query_param <=", value, "queryParam");
            return (Criteria) this;
        }

        public Criteria andQueryParamLike(String value) {
            addCriterion("query_param like", value, "queryParam");
            return (Criteria) this;
        }

        public Criteria andQueryParamNotLike(String value) {
            addCriterion("query_param not like", value, "queryParam");
            return (Criteria) this;
        }

        public Criteria andQueryParamIn(List<String> values) {
            addCriterion("query_param in", values, "queryParam");
            return (Criteria) this;
        }

        public Criteria andQueryParamNotIn(List<String> values) {
            addCriterion("query_param not in", values, "queryParam");
            return (Criteria) this;
        }

        public Criteria andQueryParamBetween(String value1, String value2) {
            addCriterion("query_param between", value1, value2, "queryParam");
            return (Criteria) this;
        }

        public Criteria andQueryParamNotBetween(String value1, String value2) {
            addCriterion("query_param not between", value1, value2, "queryParam");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andPhoneTypeIsNull() {
            addCriterion("phone_type is null");
            return (Criteria) this;
        }

        public Criteria andPhoneTypeIsNotNull() {
            addCriterion("phone_type is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneTypeEqualTo(String value) {
            addCriterion("phone_type =", value, "phoneType");
            return (Criteria) this;
        }

        public Criteria andPhoneTypeNotEqualTo(String value) {
            addCriterion("phone_type <>", value, "phoneType");
            return (Criteria) this;
        }

        public Criteria andPhoneTypeGreaterThan(String value) {
            addCriterion("phone_type >", value, "phoneType");
            return (Criteria) this;
        }

        public Criteria andPhoneTypeGreaterThanOrEqualTo(String value) {
            addCriterion("phone_type >=", value, "phoneType");
            return (Criteria) this;
        }

        public Criteria andPhoneTypeLessThan(String value) {
            addCriterion("phone_type <", value, "phoneType");
            return (Criteria) this;
        }

        public Criteria andPhoneTypeLessThanOrEqualTo(String value) {
            addCriterion("phone_type <=", value, "phoneType");
            return (Criteria) this;
        }

        public Criteria andPhoneTypeLike(String value) {
            addCriterion("phone_type like", value, "phoneType");
            return (Criteria) this;
        }

        public Criteria andPhoneTypeNotLike(String value) {
            addCriterion("phone_type not like", value, "phoneType");
            return (Criteria) this;
        }

        public Criteria andPhoneTypeIn(List<String> values) {
            addCriterion("phone_type in", values, "phoneType");
            return (Criteria) this;
        }

        public Criteria andPhoneTypeNotIn(List<String> values) {
            addCriterion("phone_type not in", values, "phoneType");
            return (Criteria) this;
        }

        public Criteria andPhoneTypeBetween(String value1, String value2) {
            addCriterion("phone_type between", value1, value2, "phoneType");
            return (Criteria) this;
        }

        public Criteria andPhoneTypeNotBetween(String value1, String value2) {
            addCriterion("phone_type not between", value1, value2, "phoneType");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeIsNull() {
            addCriterion("browser_type is null");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeIsNotNull() {
            addCriterion("browser_type is not null");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeEqualTo(String value) {
            addCriterion("browser_type =", value, "browserType");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeNotEqualTo(String value) {
            addCriterion("browser_type <>", value, "browserType");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeGreaterThan(String value) {
            addCriterion("browser_type >", value, "browserType");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeGreaterThanOrEqualTo(String value) {
            addCriterion("browser_type >=", value, "browserType");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeLessThan(String value) {
            addCriterion("browser_type <", value, "browserType");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeLessThanOrEqualTo(String value) {
            addCriterion("browser_type <=", value, "browserType");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeLike(String value) {
            addCriterion("browser_type like", value, "browserType");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeNotLike(String value) {
            addCriterion("browser_type not like", value, "browserType");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeIn(List<String> values) {
            addCriterion("browser_type in", values, "browserType");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeNotIn(List<String> values) {
            addCriterion("browser_type not in", values, "browserType");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeBetween(String value1, String value2) {
            addCriterion("browser_type between", value1, value2, "browserType");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeNotBetween(String value1, String value2) {
            addCriterion("browser_type not between", value1, value2, "browserType");
            return (Criteria) this;
        }

        public Criteria andBrowserVersionIsNull() {
            addCriterion("browser_version is null");
            return (Criteria) this;
        }

        public Criteria andBrowserVersionIsNotNull() {
            addCriterion("browser_version is not null");
            return (Criteria) this;
        }

        public Criteria andBrowserVersionEqualTo(String value) {
            addCriterion("browser_version =", value, "browserVersion");
            return (Criteria) this;
        }

        public Criteria andBrowserVersionNotEqualTo(String value) {
            addCriterion("browser_version <>", value, "browserVersion");
            return (Criteria) this;
        }

        public Criteria andBrowserVersionGreaterThan(String value) {
            addCriterion("browser_version >", value, "browserVersion");
            return (Criteria) this;
        }

        public Criteria andBrowserVersionGreaterThanOrEqualTo(String value) {
            addCriterion("browser_version >=", value, "browserVersion");
            return (Criteria) this;
        }

        public Criteria andBrowserVersionLessThan(String value) {
            addCriterion("browser_version <", value, "browserVersion");
            return (Criteria) this;
        }

        public Criteria andBrowserVersionLessThanOrEqualTo(String value) {
            addCriterion("browser_version <=", value, "browserVersion");
            return (Criteria) this;
        }

        public Criteria andBrowserVersionLike(String value) {
            addCriterion("browser_version like", value, "browserVersion");
            return (Criteria) this;
        }

        public Criteria andBrowserVersionNotLike(String value) {
            addCriterion("browser_version not like", value, "browserVersion");
            return (Criteria) this;
        }

        public Criteria andBrowserVersionIn(List<String> values) {
            addCriterion("browser_version in", values, "browserVersion");
            return (Criteria) this;
        }

        public Criteria andBrowserVersionNotIn(List<String> values) {
            addCriterion("browser_version not in", values, "browserVersion");
            return (Criteria) this;
        }

        public Criteria andBrowserVersionBetween(String value1, String value2) {
            addCriterion("browser_version between", value1, value2, "browserVersion");
            return (Criteria) this;
        }

        public Criteria andBrowserVersionNotBetween(String value1, String value2) {
            addCriterion("browser_version not between", value1, value2, "browserVersion");
            return (Criteria) this;
        }

        public Criteria andOsTypeIsNull() {
            addCriterion("os_type is null");
            return (Criteria) this;
        }

        public Criteria andOsTypeIsNotNull() {
            addCriterion("os_type is not null");
            return (Criteria) this;
        }

        public Criteria andOsTypeEqualTo(String value) {
            addCriterion("os_type =", value, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeNotEqualTo(String value) {
            addCriterion("os_type <>", value, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeGreaterThan(String value) {
            addCriterion("os_type >", value, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeGreaterThanOrEqualTo(String value) {
            addCriterion("os_type >=", value, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeLessThan(String value) {
            addCriterion("os_type <", value, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeLessThanOrEqualTo(String value) {
            addCriterion("os_type <=", value, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeLike(String value) {
            addCriterion("os_type like", value, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeNotLike(String value) {
            addCriterion("os_type not like", value, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeIn(List<String> values) {
            addCriterion("os_type in", values, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeNotIn(List<String> values) {
            addCriterion("os_type not in", values, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeBetween(String value1, String value2) {
            addCriterion("os_type between", value1, value2, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeNotBetween(String value1, String value2) {
            addCriterion("os_type not between", value1, value2, "osType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIsNull() {
            addCriterion("device_type is null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIsNotNull() {
            addCriterion("device_type is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeEqualTo(String value) {
            addCriterion("device_type =", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotEqualTo(String value) {
            addCriterion("device_type <>", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeGreaterThan(String value) {
            addCriterion("device_type >", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("device_type >=", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLessThan(String value) {
            addCriterion("device_type <", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLessThanOrEqualTo(String value) {
            addCriterion("device_type <=", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLike(String value) {
            addCriterion("device_type like", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotLike(String value) {
            addCriterion("device_type not like", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIn(List<String> values) {
            addCriterion("device_type in", values, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotIn(List<String> values) {
            addCriterion("device_type not in", values, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeBetween(String value1, String value2) {
            addCriterion("device_type between", value1, value2, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotBetween(String value1, String value2) {
            addCriterion("device_type not between", value1, value2, "deviceType");
            return (Criteria) this;
        }

        public Criteria andOsVersionIsNull() {
            addCriterion("os_version is null");
            return (Criteria) this;
        }

        public Criteria andOsVersionIsNotNull() {
            addCriterion("os_version is not null");
            return (Criteria) this;
        }

        public Criteria andOsVersionEqualTo(String value) {
            addCriterion("os_version =", value, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionNotEqualTo(String value) {
            addCriterion("os_version <>", value, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionGreaterThan(String value) {
            addCriterion("os_version >", value, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionGreaterThanOrEqualTo(String value) {
            addCriterion("os_version >=", value, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionLessThan(String value) {
            addCriterion("os_version <", value, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionLessThanOrEqualTo(String value) {
            addCriterion("os_version <=", value, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionLike(String value) {
            addCriterion("os_version like", value, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionNotLike(String value) {
            addCriterion("os_version not like", value, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionIn(List<String> values) {
            addCriterion("os_version in", values, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionNotIn(List<String> values) {
            addCriterion("os_version not in", values, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionBetween(String value1, String value2) {
            addCriterion("os_version between", value1, value2, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionNotBetween(String value1, String value2) {
            addCriterion("os_version not between", value1, value2, "osVersion");
            return (Criteria) this;
        }

        public Criteria andTransformStatusIsNull() {
            addCriterion("transform_status is null");
            return (Criteria) this;
        }

        public Criteria andTransformStatusIsNotNull() {
            addCriterion("transform_status is not null");
            return (Criteria) this;
        }

        public Criteria andTransformStatusEqualTo(Integer value) {
            addCriterion("transform_status =", value, "transformStatus");
            return (Criteria) this;
        }

        public Criteria andTransformStatusNotEqualTo(Integer value) {
            addCriterion("transform_status <>", value, "transformStatus");
            return (Criteria) this;
        }

        public Criteria andTransformStatusGreaterThan(Integer value) {
            addCriterion("transform_status >", value, "transformStatus");
            return (Criteria) this;
        }

        public Criteria andTransformStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("transform_status >=", value, "transformStatus");
            return (Criteria) this;
        }

        public Criteria andTransformStatusLessThan(Integer value) {
            addCriterion("transform_status <", value, "transformStatus");
            return (Criteria) this;
        }

        public Criteria andTransformStatusLessThanOrEqualTo(Integer value) {
            addCriterion("transform_status <=", value, "transformStatus");
            return (Criteria) this;
        }

        public Criteria andTransformStatusIn(List<Integer> values) {
            addCriterion("transform_status in", values, "transformStatus");
            return (Criteria) this;
        }

        public Criteria andTransformStatusNotIn(List<Integer> values) {
            addCriterion("transform_status not in", values, "transformStatus");
            return (Criteria) this;
        }

        public Criteria andTransformStatusBetween(Integer value1, Integer value2) {
            addCriterion("transform_status between", value1, value2, "transformStatus");
            return (Criteria) this;
        }

        public Criteria andTransformStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("transform_status not between", value1, value2, "transformStatus");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}