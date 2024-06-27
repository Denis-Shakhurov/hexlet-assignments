package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> tempMap = storage.toMap();
        var keys = storage.toMap().keySet();
        for (String key : keys) {
            storage.unset(key);
        }
        var entrys = tempMap.entrySet();
        for (var entry : entrys) {
            String key = entry.getKey();
            String value = entry.getValue();
            storage.set(value, key);
        }
    }
}
// END
