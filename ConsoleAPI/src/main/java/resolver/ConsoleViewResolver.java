package resolver;

import mvc.ConsoleView;

import java.util.HashMap;
import java.util.Map;

public class ConsoleViewResolver {

    private Map<String, ConsoleView> views;

    public ConsoleViewResolver(Map<String, ConsoleView> views) {
        this.views = views;
    }

    public ConsoleView resolve(String view) {
        return views.get(view);
    }
}
