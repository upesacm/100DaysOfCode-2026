import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        // Remove all spaces
        String result = str.replace(" ", "");

        System.out.println(result);

        sc.close();
    }
}
