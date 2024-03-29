package com.xebia.app.config;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public Docket getSwaggerDocker(String applicationName) {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(Predicates.not(PathSelectors.regex("/error")))
				.build()
				.apiInfo(metadata(applicationName))
				.useDefaultResponseMessages(false)
				.securitySchemes(new ArrayList<>(Arrays.asList(new ApiKey("Bearer %token", "Authorization", "Header"))))
				.tags(new Tag("users", "Operations about users"))
				.tags(new Tag("ping", "Just a ping"))
				.genericModelSubstitutes(Optional.class);
	}

	private ApiInfo metadata(String applicationName) {
		return new ApiInfoBuilder()
				.title(StringUtils.capitalize(applicationName) + " Api Documentation")
				.description("")
				.version("1.0.0")
				.license(" License")
				.contact(new Contact(null, null, "admin@in.ab.com"))
				.build();
	}
}
