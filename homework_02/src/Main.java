//Реализовать 2 потока:
//первый поток должен выводить на экран все числа, которые делятся на 2;
//второй поток должен выводить все числа которые делятся на 3;
//Main должен запускать оба эти потока, засыпать на 3 секунды и завершать выполнение программы (т.е. оба потока тоже должны прекратить свою работу)

public class Main {
    public static void main(String[] args) {

        int sleepTime = 3;

        Thread1 thread1 = new Thread1();
        thread1.setDaemon(true);

        Thread thread2 = new Thread(new Thread2());
        thread2.setDaemon(true);

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(sleepTime*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main stop");
    }

}
