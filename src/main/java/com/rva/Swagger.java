package com.rva;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@EnableSwagger2
@Configuration
public class Swagger {
    public static final Contact DEFAULT_CONTACT = new Contact(
            "Vuk Pekez",
            "https://github.com/vukpekez",
            "vukpekez@uns.ac.rs"
    );

    public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
            "Backend RVA Swagger ",
            "Razvoj viseslojnih aplikacija",
            "1.0",
            "",
            DEFAULT_CONTACT,
            "",
            "",
            new ArrayList<>());

    @Bean
    Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.rva"))
                .build()
                .apiInfo(DEFAULT_API_INFO);
    }
}
