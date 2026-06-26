import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String result = s.replace(" ", "");
        System.out.println(result);
        sc.close();
    }
}