package exercise;

// BEGIN
public class MaxThread extends Thread {
    private Integer max = Integer.MIN_VALUE;
    private int[] numbers;

    public MaxThread(int[] numbers) {
        this.numbers = numbers;
    }
    public Integer getMax() {
        return max;
    }

    public void run() {
        for (Integer num : numbers) {
            if (num > max) {
                max = num;
            }
        }
    }
}
// END
