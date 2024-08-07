public class MyTask implements Runnable {
    @Override
    public void run() {

            System.out.println("start Thread 2");
            for (int i = 100; i < 110; i++) {
                System.out.println("MyThread2: " + i);

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("end Thread 2");
        }
    }

