import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        int a = 10;
        int b = 0;
        int res = div (a, b);
        System.out.println(res);

        try {
            m1();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
    public static int div(int a, int b) {
        int result;
        try {
         result = a / b;
         return result ;
        } catch (Exception e) {
            System.out.println("error");
        }

        return 0;
    }
    public static void m1() throws Exception {
        throw new Exception();

    }
}
