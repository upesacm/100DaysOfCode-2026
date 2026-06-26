import java.util.*;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the first array:");
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        System.out.println("Enter the elements of the first array:");
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        System.out.println("Enter the size of the second array:");
        int m = sc.nextInt();
        System.out.println("Enter the elements of the second array:");
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        TreeSet<Integer> s = new TreeSet<>();
        for(int x:arr1){
            s.add(x);
        }
        for(int x:arr2){
            s.add(x);
        }
        System.out.println(s);
        sc.close();

    }
}
