package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    private Map<String, String> map;

    public InMemoryKV(Map<String, String> map) {
        this.map = map;
    }

    @Override
    public void set(String key, String value) {
        Map<String, String> tempMap = new HashMap<>(map);
        tempMap.put(key, value);
        map = tempMap;
    }

    @Override
    public void unset(String key) {
        Map<String, String> tempMap = new HashMap<>(map);
        tempMap.remove(key);
        map = tempMap;
    }

    @Override
    public String get(String key, String defaultValue) {
        if (map.containsKey(key)) {
            return map.get(key);
        } else {
            return defaultValue;
        }
    }

    @Override
    public Map<String, String> toMap() {
        return Map.copyOf(map);
    }
}
// END
