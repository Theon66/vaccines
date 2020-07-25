package cn.yxyz.vaccines.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * Swaager API文档配置
 */
@Configuration
@EnableSwagger2
class Swagger2 {

 @Bean
 public Docket createRestApi() {
  return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("cn.yxyz.vaccines")).paths(PathSelectors.any())
          .build();
 }

 private ApiInfo apiInfo() {
  return new ApiInfoBuilder().title("预防接种疫苗api文档").description("描述").termsOfServiceUrl("。。。。").version("1.0").build();
 }
}
