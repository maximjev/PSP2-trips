package servlet;

import mvc.ConsoleController;
import mvc.ConsoleModel;
import resolver.ConsoleViewResolver;

import java.util.Scanner;

public class ConsoleDispatcher {

    private ConsoleController controller;

    private ConsoleViewResolver resolver;

    private ConsoleModel model;

    public ConsoleDispatcher(ConsoleController controller, ConsoleViewResolver resolver, ConsoleModel model) {
        this.controller = controller;
        this.resolver = resolver;
        this.model = model;
    }

    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            String command, view;
            while (true) {
                command = scanner.nextLine();
                view = controller.execute(command);
                if (view.equals("exit")) {
                    break;
                }
                resolver.resolve(view).render(model);
            }
        }
    }
}
