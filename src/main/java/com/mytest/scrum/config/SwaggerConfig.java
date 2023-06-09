package com.mytest.scrum.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableAutoConfiguration
//@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket userApi(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.mytest.scrum.controller")).build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("Scrum Retrospective").description("Scrum Retrospective using Spring")
                .version("2.0").build();
    }
}
