package in.co.userrole.configuration;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket postsApi() {
    return new Docket(DocumentationType.SWAGGER_2).groupName("user-role-api")
        .useDefaultResponseMessages(false).apiInfo(apiInfo()).select().paths(regex("/.*")).build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("User-Role-Service").description("user role").version("1.0")
        .build();
  }
}
