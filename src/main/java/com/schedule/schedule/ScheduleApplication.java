package com.schedule.schedule;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.logging.LogLevel;

import static com.schedule.schedule.util.CommonUtil.logging;


@Slf4j
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ScheduleApplication {

    @Value("${server.host:8080}")
    private Integer SERVER_HOST;

    public static void main(String[] args) {
        SpringApplication.run(ScheduleApplication.class, args);
    }

    @PostConstruct
    public void init() {
        logging(LogLevel.INFO,
                "server properties start",
                "server host = %s".formatted(SERVER_HOST),
                "server properties end"
        );

    }

}
