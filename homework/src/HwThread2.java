public class HwThread2 implements Runnable {
    int i=0;
    @Override
    public void run() {
        System.out.println("Thread run: " + Thread.currentThread().getName());
        while (true) {
            System.out.println("Thread2 x3 : " + (i++)*3);

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
