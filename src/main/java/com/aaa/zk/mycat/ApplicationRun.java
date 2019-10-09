package com.aaa.zk.mycat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName ApplicationRun
 * @Author 赵凯
 * @Date 2019/9/20 22:06}
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("com.aaa.zk.mycat.mapper")
public class ApplicationRun {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun.class, args);
    }
}
