package dbRecorder.main;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(
		info = @Info(title = "Data Base Recorder",
				version = "1.0",
				description = "The application will be used to save records to our database"))
@SpringBootApplication
public class DbRecorderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbRecorderApplication.class, args);
	}

}
