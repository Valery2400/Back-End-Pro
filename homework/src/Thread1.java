public class Thread1 extends Thread {
    int i = 0;
    public void run() {
        System.out.println("Thread run: " + Thread.currentThread().getName());
        while (true) {
            System.out.println("Thread1 x2 : " + (i++)*2);

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }


    }
}
