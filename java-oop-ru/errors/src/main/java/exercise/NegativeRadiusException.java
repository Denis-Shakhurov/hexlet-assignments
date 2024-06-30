package exercise;

// BEGIN
public class NegativeRadiusException extends Exception {
    private String text;
    public NegativeRadiusException(String text) {
        this.text = text;
    }
}
// END
