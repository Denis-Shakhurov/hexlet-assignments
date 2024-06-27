package exercise;

// BEGIN
import java.util.Map;

public class FileKV implements KeyValueStorage {
    private String path;
    private Map<String, String> map;

    public FileKV(String path, Map<String, String> map) {
        this.path = path;
        this.map = map;
    }

    @Override
    public void set(String key, String value) {
        String content = Utils.readFile(path);
        Map<String, String> tempMap = Utils.unserialize(content);
        tempMap.put(key, value);
        map = tempMap;
        String json = Utils.serialize(map);
        Utils.writeFile(path, json);
    }

    @Override
    public void unset(String key) {
        String content = Utils.readFile(path);
        Map<String, String> tempMap = Utils.unserialize(content);
        tempMap.remove(key);
        map = tempMap;
        String json = Utils.serialize(map);
        Utils.writeFile(path, json);
    }

    @Override
    public String get(String key, String defaultValue) {
        String content = Utils.readFile(path);
        Map<String, String> tempMap = Utils.unserialize(content);
        if (tempMap.containsKey(key)) {
            return tempMap.get(key);
        } else {
            return defaultValue;
        }
    }

    @Override
    public Map<String, String> toMap() {
        String content = Utils.readFile(path);
        return Utils.unserialize(content);
    }
}
// END
