package tw.jerome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "API展示", version = "1.0.0"))
@SpringBootApplication
public class MmsWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(MmsWebApplication.class, args);
	}

}
