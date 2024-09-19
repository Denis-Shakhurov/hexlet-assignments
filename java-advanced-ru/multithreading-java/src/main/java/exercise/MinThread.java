package exercise;

// BEGIN
public class MinThread extends Thread {
    private Integer min = Integer.MAX_VALUE;
    private int[] numbers;

    public MinThread(int[] numbers) {
        this.numbers = numbers;
    }

    public Integer getMin() {
        return min;
    }

    public void run() {
        for (Integer num : numbers) {
            if (num < min) {
                min = num;
            }
        }
    }
}
// END
