package cn.yxyz.vaccines;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@MapperScan("cn.yxyz.vaccines.mapper")
public class VaccinesApplication {
    public static void main(String[] args) {
        SpringApplication.run(VaccinesApplication.class, args);
    }

}