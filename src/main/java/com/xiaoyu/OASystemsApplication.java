package com.xiaoyu;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
@MapperScan("com.xiaoyu.mapper")
public class OASystemsApplication {
    public static void main( String[] args ) {

        SpringApplication.run(OASystemsApplication.class, args);
    }
}
