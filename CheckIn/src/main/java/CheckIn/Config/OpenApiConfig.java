package CheckIn.Config;

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
				             .title("Check-In")
				             .description("Update CheckIn Status of Passenger")
				             .version("v1.0")
				             .contact(new Contact()
				            		 .name("Thamica")
				            		 .email("thamica3067@gmail.com"))
				             .termsOfService("Terms")
				             .license(new License().name("License").url("#")));
	}
}