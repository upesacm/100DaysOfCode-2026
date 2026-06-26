import java.util.Scanner;

public class Question_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username: ");
        String s = sc.nextLine();

        int count = 0;

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (s.indexOf(ch) != -1) {
                count++;
            }
        }

        if (count % 2 == 0) {
            System.out.println("CHAT WITH HER!");
        } else {
            System.out.println("IGNORE HIM!");
        }

        sc.close();
    }
}