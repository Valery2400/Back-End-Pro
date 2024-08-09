public class Main1 {
    private static int counter = 0;

    public static void main(String[] args) {
        System.out.println("Main start");

        Thread[] threads = {
                new Thread(new Task()),
                new Thread(new Task()),
                new Thread(new Task()),

        };
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


        System.out.println("Main end. Counter = " + counter);
    }

    public static synchronized void setCounter () {

        counter++;
    }

}
