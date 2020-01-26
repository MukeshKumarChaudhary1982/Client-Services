package com.dxc.ClientServices;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer{
	
	public static final Contact DEFAULT_CONTACT = new Contact("First Name", "http://abc.com", "abc@abc.com");
	  public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("My API Application", "My Api Documentation", "1.0", "urn:tos",
	          DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());
	//private static  Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<>();

	@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_API_INFO)
				.select()
				.apis(RequestHandlerSelectors
				.basePackage("com.dxc.ClientServices"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .enableUrlTemplating(false); 
		//		.produces(DEFAULT_PRODUCES_AND_CONSUMES)
			//	.consumes(DEFAULT_PRODUCES_AND_CONSUMES);
	}
	
	 /* @Bean
	    public Docket api() { 
	        return new Docket(DocumentationType.SWAGGER_2)  
	          .select()                                  
	          .apis(RequestHandlerSelectors.any())              
	          .paths(PathSelectors.any())                          
	          .build();                                           
	    }*/

}
