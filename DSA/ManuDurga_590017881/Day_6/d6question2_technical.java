package Day_6;

import java.util.Arrays;
import java.util.Scanner;

public class d6question2_technical {
    public int[] union(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                result[k++] = a[i++];
            } else if (b[j] < a[i]) {
                result[k++] = b[j++];
            } else { // equal
                result[k++] = a[i];
                i++;
                j++;
            }
        }

        while (i < a.length) result[k++] = a[i++];
        while (j < b.length) result[k++] = b[j++];

        // shrink to actual size
        int[] unionArr = new int[k];
        for (int x = 0; x < k; x++) unionArr[x] = result[x];
        return unionArr;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();          // size of the input array
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();     // elements of the array
        }
        System.out.println("new array");
        int m = sc.nextInt();          // size of the input array
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();     // elements of the array
        }

        d6question2_technical obj = new d6question2_technical();
        System.out.println(Arrays.toString(obj.union(a,b)));
    }
}
