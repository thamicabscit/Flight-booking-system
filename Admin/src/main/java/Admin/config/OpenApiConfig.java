package Admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {
	
	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI().info(new Info()
				             .title("Admin")
				             .description("Admin Abilities for complete System")
				             .version("v1.0")
				             .contact(new Contact()
				            		 .name("Thamica")
				            		 .email("thamica3067@gmail.com"))
				             .termsOfService("Terms")
				             .license(new License().name("License").url("#")));
	}
}