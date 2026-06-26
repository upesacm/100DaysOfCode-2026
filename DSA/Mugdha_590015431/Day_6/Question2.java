package DSA.Mugdha_590015431.Day_6;

import java.util.*;

public class Question2{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int a[] = new int[n1];

        for(int i = 0; i < n1; i++) {
            a[i] = sc.nextInt();
        }

        int n2 = sc.nextInt();
        int b[] = new int[n2];

        for(int i = 0; i < n2; i++) {
            b[i] = sc.nextInt();
        }

        ArrayList<Integer> result = union(a, b);

        System.out.println(result);

        sc.close();
    }

    public static ArrayList<Integer> union(int a[], int b[]) {
        ArrayList<Integer> ans = new ArrayList<>();

        int i = 0, j = 0;

        while(i < a.length && j < b.length) {

            if(a[i] <= b[j]) {

                if(ans.size() == 0 || ans.get(ans.size() - 1) != a[i]) {
                    ans.add(a[i]);
                }

                i++;
            }
            else {

                if(ans.size() == 0 || ans.get(ans.size() - 1) != b[j]) {
                    ans.add(b[j]);
                }

                j++;
            }
        }

        while(i < a.length) {

            if(ans.size() == 0 || ans.get(ans.size() - 1) != a[i]) {
                ans.add(a[i]);
            }

            i++;
        }

        while(j < b.length) {

            if(ans.size() == 0 || ans.get(ans.size() - 1) != b[j]) {
                ans.add(b[j]);
            }

            j++;
        }

        return ans;
    }
}