import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        int xor = x ^ y;
        int count = 0;

        while (xor != 0) {
            count += xor & 1;
            xor >>= 1;
        }

        System.out.println(count);
    }
}