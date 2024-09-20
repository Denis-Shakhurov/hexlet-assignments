package exercise;

class App {

    public static void main(String[] args) throws InterruptedException {
        // BEGIN
        SafetyList safetyList = new SafetyList();

        Thread thread = new Thread(new ListThread(safetyList));

        thread.start();

        thread.join();

        System.out.println(safetyList.getSize());
        // END
    }
}

