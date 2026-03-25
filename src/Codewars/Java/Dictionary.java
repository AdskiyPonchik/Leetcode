package Codewars.Java;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private final Map<String, String> map = new HashMap<>();

    public Dictionary() {
    }

    public void newEntry(String key, String value) {
        map.put(key, value);
    }

    public String look(String key) {
        return map.getOrDefault(key, "Cant find entry for " + key);
    }
}
