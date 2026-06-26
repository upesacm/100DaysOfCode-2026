import java.util.ArrayList;
import java.util.Scanner;

public class d6q2 {
    public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the size of the first array: ");
        n = s.nextInt();

        ArrayList<Integer> a = new ArrayList<>(n);
        System.out.println("Enter the elements of the first array: ");

        for (int i = 0; i<n; i++) {
            a.add(s.nextInt());
        }

        System.out.println("Enter the size of the second array: ");
        int n2 = s.nextInt();

        ArrayList<Integer> b = new ArrayList<>(n2);
        System.out.println("Enter the elements of the second array: ");

        for (int i = 0; i<n2; i++) {
            b.add(s.nextInt());
        }

        ArrayList<Integer> union = new ArrayList<>();

        for (int i = 0; i<n; i++) {
            if (!union.contains(a.get(i))) {
                union.add(a.get(i));
            }
        }

        for (int i = 0; i<n2; i++) {
            if (!union.contains(b.get(i))) {
                union.add(b.get(i));
            }
        }

        System.out.println("The union of the two arrays is: " + union);
    }
}
