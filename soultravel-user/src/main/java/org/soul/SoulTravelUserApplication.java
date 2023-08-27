package org.soul;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("org.soul.mapper")
@SpringBootApplication
public class SoulTravelUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(SoulTravelUserApplication.class);
    }
}