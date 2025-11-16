package co.nz.csoft.elasticsearch;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableScheduling
@SpringBootApplication
@ComponentScan(basePackages = "co.nz.csoft.elasticsearch")
public class ElasticJavaApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(ElasticJavaApiApplication.class, args);
		System.out.println("elastic Application started");
	}
	
	@Configuration
	@EnableSwagger2
	public class SwaggerConfig {
		private ApiInfo apiInfo() {
			return new ApiInfo("Hotelmate Elastic API", "Hotelmate Elastic API ",
					"v1", "CredenceSoft's Fair Usage Policy",
					new Contact("CredenceSoft Limited", "https://www.credencesoft.co.nz",
							"samaya.muduli@credencesoft.co.nz"),
					"License of API", "API license URL", Collections.emptyList());
		}

		@Bean
		public Docket propertyApi() {
			return new Docket(DocumentationType.SWAGGER_2).select()
					.apis(RequestHandlerSelectors.basePackage("co.nz.csoft.elasticsearch.controller"))
					.paths(PathSelectors.ant("/api/**")).build().groupName("Property").apiInfo(apiInfo());
		}
		/*
		@Bean
		public Docket bookingApi() {
			return new Docket(DocumentationType.SWAGGER_2).select()
					.apis(RequestHandlerSelectors.basePackage("co.nz.csoft.elasticsearch.controller"))
					.paths(PathSelectors.ant("/api/booking/**")).build().groupName("Booking").apiInfo(apiInfo());
		}*/

	}

	@Configuration
	@EnableWebMvc
	public class WebConfig implements WebMvcConfigurer {

		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**");
		}

		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
			registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		}
	}
}
