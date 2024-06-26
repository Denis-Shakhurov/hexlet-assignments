package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    private String text;

    public ReversedSequence(String text) {
        StringBuilder sb = new StringBuilder(text);
        this.text = sb.reverse().toString();
    }

    @Override
    public int length() {
        return text.length();
    }

    @Override
    public char charAt(int index) {
        return text.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return text.substring(start, end);
    }
    
    @Override
    public String toString() {
        return text;
    }
}
// END
