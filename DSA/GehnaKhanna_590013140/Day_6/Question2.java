import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size of first array
        System.out.print("Enter size of first array: ");
        int n = sc.nextInt();
        int[] arr1 = new int[n];

        System.out.println("Enter elements of first sorted array:");
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        // Input size of second array
        System.out.print("Enter size of second array: ");
        int m = sc.nextInt();
        int[] arr2 = new int[m];

        System.out.println("Enter elements of second sorted array:");
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        ArrayList<Integer> union = new ArrayList<>();

        int i = 0, j = 0;

        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                if (!union.contains(arr1[i]))
                    union.add(arr1[i]);
                i++;
            } else if (arr1[i] > arr2[j]) {
                if (!union.contains(arr2[j]))
                    union.add(arr2[j]);
                j++;
            } else {
                if (!union.contains(arr1[i]))
                    union.add(arr1[i]);
                i++;
                j++;
            }
        }

        while (i < n) {
            if (!union.contains(arr1[i]))
                union.add(arr1[i]);
            i++;
        }

        while (j < m) {
            if (!union.contains(arr2[j]))
                union.add(arr2[j]);
            j++;
        }

        System.out.println("Union of arrays: " + union);

        sc.close();
    }
}
