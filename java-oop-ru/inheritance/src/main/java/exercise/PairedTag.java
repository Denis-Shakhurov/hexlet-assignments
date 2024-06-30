package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag  extends Tag {
    private String body;
    private List<Tag> listSingleTag;

    public PairedTag(String name, Map<String, String> map, String body, List<Tag> listSingleTag) {
        super(name, map);
        this.body = body;
        this.listSingleTag = listSingleTag;
    }

    @Override
    public String toString() {
        String superToString = super.toString();

        String res = listSingleTag.stream()
                .map(Tag :: toString)
                .collect(Collectors.joining());

        return String.format("%s%s%s</%s>", superToString, body, res, getName());
    }
}
// END
