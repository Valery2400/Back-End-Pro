public class Task implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start");
        for (int i = 0; i < 1_000_000; i++) {

            Main1.setCounter();
            Main2.setCounter();
        }
        System.out.println(Thread.currentThread().getName() + " end");
    }
}
