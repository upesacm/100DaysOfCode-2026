import java.util.Scanner;

public class Question_1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] width = new int[26];

        System.out.println("Enter widths of 26 letters:");
        for(int i = 0; i < 26; i++) {
            width[i] = sc.nextInt();
        }

        System.out.print("Enter the string: ");
        String s = sc.next();

        int lines = 1;
        int sum = 0;

        for(int i = 0; i < s.length(); i++) {

            int w = width[s.charAt(i) - 'a'];

            if(sum + w > 100) {
                lines++;
                sum = w;
            }
            else {
                sum += w;
            }
        }

        System.out.println("Total lines = " + lines);
        System.out.println("Width of last line = " + sum);
    }
}