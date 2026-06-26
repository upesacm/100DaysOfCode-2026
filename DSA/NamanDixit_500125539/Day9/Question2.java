
import java.util.*;

class Question2 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String str = sc.nextLine();
        String str1 = str.replaceAll(" ", "");
        System.out.println(str1);
    }
}
