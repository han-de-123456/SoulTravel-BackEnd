package org.soul;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@MapperScan(basePackages = "org.soul.mapper")
@EnableDiscoveryClient
@RefreshScope
@SpringBootApplication
public class SoulTravelUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(SoulTravelUserApplication.class);
    }
}