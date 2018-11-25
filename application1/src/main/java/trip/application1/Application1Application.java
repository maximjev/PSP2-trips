package trip.application1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import trip.application1.configuration.AppConfig;

@SpringBootApplication(scanBasePackages = { "trip.application1", "trip.offerController", "trip.ticketController"})
@Import(AppConfig.class)
public class Application1Application {

	public static void main(String[] args) {
		SpringApplication.run(Application1Application.class, args);
	}
}
