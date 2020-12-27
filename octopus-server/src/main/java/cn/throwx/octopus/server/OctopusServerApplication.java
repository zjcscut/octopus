package cn.throwx.octopus.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author throwable
 * @version v1
 * @description
 * @since 2020/12/26 12:43
 */
@EnableScheduling
@SpringBootApplication
public class OctopusServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OctopusServerApplication.class, args);
    }
}
