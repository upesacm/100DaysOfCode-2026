
import java.util.*;

class Question2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = sc.nextLine();
        String z = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            z = z + str.charAt(i);
        }
        System.out.println("Reversed String: " + z);
    }
}
