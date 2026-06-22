import java.util.Scanner;
public class Question_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        char[] letters = s.toCharArray();

        int i = 0;
        int j = letters.length - 1;

        while (i < j) {
            // Swap characters from both ends until the middle is reached
            char temp = letters[i];
            letters[i] = letters[j];
            letters[j] = temp;

            i++;
            j--;
        }

        String reversed = new String(letters);

        System.out.println("Reversed string: " + reversed);
    }

}
