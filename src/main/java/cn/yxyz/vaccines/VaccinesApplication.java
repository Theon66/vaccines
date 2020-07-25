package cn.yxyz.vaccines;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@MapperScan("cn.yxyz.vaccines.mapper")
public class VaccinesApplication {
    public static void main(String[] args) {
        SpringApplication.run(VaccinesApplication.class, args);
    }

}
