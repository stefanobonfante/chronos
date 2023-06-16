package it.addvalue.chronos.core.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SpringFoxConfig {
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        // FIXME: use this api to only expected apis
        //        .apis(
        //            RequestHandlerSelectors.basePackage("it.addvalue.chronos.controller")
        //                .or(
        //                    RequestHandlerSelectors.basePackage(
        //                        "org.springframework.boot.actuate.endpoint")))
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfo(
        "Chronos REST API",
        "Management of loads and expenses of API.",
        "0.0.1",
        "Terms of service",
        new Contact("Add Value", "http://www.addvalue.it", "contact@addvalue.it"),
        "Apache 2.0",
        "https://www.apache.org/licenses/LICENSE-2.0",
        Collections.emptyList());
  }
}
