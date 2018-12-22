package com.czh.cloud.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Hello world!
 */
@SpringBootApplication
@RestController
@EnableDiscoveryClient
@EnableHystrixDashboard
@EnableTurbine // http://127.0.0.1:12086/hystrix
public class BootOfTurbine {
    public static void main(String[] args) throws Exception {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("windows")) {
            System.setProperty("log.path", "D:/chenzhehao/workspace/czh");
        } else {
            System.setProperty("log.path", "/Users/chenzhehao/Documents/logs/springcloud");
        }
        System.setProperty("context.name", "turbine-server");

        SpringApplication.run(BootOfTurbine.class, args);
    }

    @RequestMapping("/")
    public Object test() {
        return "success";
    }
}
