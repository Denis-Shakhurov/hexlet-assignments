package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    private String name;
    private Map<String, String> map;

    public Tag(String name, Map<String, String> map) {
        this.name = name;
        this.map = map;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getMap() {
        return map;
    }

    @Override
    public String toString() {
        String mapToString = map.keySet().stream()
                .map(key -> " " + key + "=\"" + map.get(key) + "\"")
                .collect(Collectors.joining());

        return String.format("<%s%s>", getName(), mapToString);
    }
}
// END
