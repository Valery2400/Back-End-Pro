public class Thread2 implements Runnable {

    @Override
    public void run() {
        int i=0;
        System.out.println("Thread run: " + Thread.currentThread().getName());
        while (true) {
            System.out.println("Thread2 x3 : " + (i++)*3);

            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
