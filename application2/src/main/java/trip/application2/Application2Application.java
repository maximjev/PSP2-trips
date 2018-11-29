package trip.application2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import trip.application2.configuration.AppConfig;

@SpringBootApplication(scanBasePackages = { "trip.application2", "trip.offerController", "trip.ticketController"})
@Import(AppConfig.class)
public class Application2Application {

	public static void main(String[] args) {
		SpringApplication.run(Application2Application.class, args);
	}
}
