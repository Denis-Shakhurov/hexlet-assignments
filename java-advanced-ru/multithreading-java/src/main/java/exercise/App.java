package exercise;

import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    public static void main(String[] args) {
        int[] numbers = {10, -4, 67, 100, -100, 8};

        System.out.println(App.getMinMax(numbers)); // => {min=-100, max=100}
    }
    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {
        Thread maxThread = new MaxThread(numbers);
        Thread minThread = new MinThread(numbers);

        LOGGER.info("Thread " + maxThread.getName() + " started");
        maxThread.start();
        LOGGER.info("Thread " + minThread.getName() + " started");
        minThread.start();
        LOGGER.info("Thread " + maxThread.getName() + " finished");
        LOGGER.info("Thread " + minThread.getName() + " finished");

        return Map.of(
                "min", ((MinThread) minThread).getMin(),
                "max", ((MaxThread) maxThread).getMax()
        );
    }
    // END
}
