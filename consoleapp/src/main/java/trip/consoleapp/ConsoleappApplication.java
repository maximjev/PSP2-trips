package trip.consoleapp;

import mvc.ConsoleController;
import mvc.ConsoleModel;
import mvc.ConsoleView;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import resolver.ConsoleViewResolver;
import servlet.ConsoleDispatcher;
import trip.consoleapp.configuration.AppConfig;
import trip.consoleapp.controller.ConsoleControllerImpl;
import trip.consoleapp.view.*;
import trip.facade.offer.FacadeOfferService;
import trip.facade.ticket.FacadeTicketService;

import java.util.HashMap;
import java.util.Map;

@Import(AppConfig.class)
@SpringBootApplication
public class ConsoleappApplication implements CommandLineRunner {

	private static ConfigurableApplicationContext ctx;

	public static void main(String[] args) {
		ctx = SpringApplication.run(ConsoleappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsoleModel model = new ConsoleModel();
		ConsoleViewResolver resolver = initResolver();

		FacadeTicketService ticketService = (FacadeTicketService) ctx.getBean("facadeTicketService");
		FacadeOfferService offerService = (FacadeOfferService) ctx.getBean("facadeOfferService");

		ConsoleController consoleController = new ConsoleControllerImpl(offerService, ticketService, model);
		ConsoleDispatcher dispatcher = new ConsoleDispatcher(consoleController, resolver, model);
		dispatcher.run();

	}

	private ConsoleViewResolver initResolver() {
		Map<String, ConsoleView> views = new HashMap<>();

		views.put("offerList", new ConsoleOfferListView());
		views.put("offerView", new ConsoleOfferView());
		views.put("offerPrice", new ConsoleOfferPriceView());
		views.put("ticketList", new ConsoleTicketListView());
		views.put("menu", new ConsoleMenuView());

		return new ConsoleViewResolver(views);
	}
}

