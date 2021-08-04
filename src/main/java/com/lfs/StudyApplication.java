package com.lfs;

import io.swagger.models.auth.In;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(basePackages = "com.lfs.mapper")
public class StudyApplication {


    private static String appName;

    private static Integer serverPort;

    @Value("${server.servlet.context-path}")
    public void setAppName(String appPath ) {
        appName = appPath;
    }

    @Value("${server.port}")
    public void setServerPort(Integer port) {
        serverPort = port;
    }

    public static void main(String[] args) {
        SpringApplication.run(StudyApplication.class, args);
        System.out.println("http://localhost:" + serverPort + appName + "/user/list");
    }

}
