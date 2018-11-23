package com.tiket.tix.project.libraries.configuration;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

  private static final String STRING = "string";
  private static final String HEADER = "header";
  private static final String USERNAME = "username";
  private TypeResolver resolver;

  @Autowired
  public void setResolver(TypeResolver resolver) {
    this.resolver = resolver;
  }

  @Bean
  public Docket init() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors
            .basePackage("com.tiket.tix.project.rest.web.controller"))
        .paths(regex("/.*"))
        .build()
        .globalOperationParameters(Arrays.asList(
            new ParameterBuilder().name("storeId").parameterType(HEADER)
                .modelRef(new ModelRef(STRING)).required(true).defaultValue("TIKETCOM")
                .description("client's store id").build(),
            new ParameterBuilder().name("channelId").parameterType(HEADER)
                .modelRef(new ModelRef(STRING)).required(true).defaultValue("WEB")
                .description("client's channelid id").build(),
            new ParameterBuilder().name("requestId").parameterType(HEADER)
                .modelRef(new ModelRef(STRING)).required(true).defaultValue("23123123")
                .description("client's request Id").build(),
            new ParameterBuilder().name("serviceId").parameterType(HEADER)
                .modelRef(new ModelRef(STRING)).required(true).defaultValue("gateway")
                .description("client's serviceId").build(),
            new ParameterBuilder().name(USERNAME).parameterType(HEADER)
                .modelRef(new ModelRef(STRING)).required(true).defaultValue(USERNAME)
                .description(USERNAME).build()));
  }
}