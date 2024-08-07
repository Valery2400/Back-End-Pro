public class MyThread1 extends Thread {
    private int start;
    private int end;

    public MyThread1(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        System.out.println("start Thread 1");
for (int i = 100; i < 110; i++) {
    System.out.println("MyThread1: " + i);

    try {
        Thread.sleep(200);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}
        System.out.println("end Thread 1");
    }
}

