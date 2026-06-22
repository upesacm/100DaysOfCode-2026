import java.util.Scanner;

public class Question {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        for (int i = str.length() - 1; i >= 0; i--) {
            System.out.print(str.charAt(i));
        }

        sc.close();
    }
}