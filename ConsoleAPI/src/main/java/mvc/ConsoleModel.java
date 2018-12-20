package mvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConsoleModel {

    private HashMap<String, Object> attributes = new HashMap<>();

    public void put(String key, Object value) {
        attributes.put(key, value);
    }
    public Object get(String key) {
        return attributes.getOrDefault(key, "");
    }
}
