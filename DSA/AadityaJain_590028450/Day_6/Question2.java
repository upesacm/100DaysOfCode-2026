/*Union of Two Sorted Arrays
Explanation
Given two sorted arrays, find the union of the arrays containing all distinct elements from both arrays. */

import java.util.*;
public class Question2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array1: ");
        int n1 = sc.nextInt();
        int i, j, k;
        int a[]= new int[n1];

        System.out.print("Enter elements in sorted order: ");
        for(i = 0; i < n1; i++){
            a[i] = sc.nextInt();
        }

        System.out.print("Enter size of array2: ");
        int n2 = sc.nextInt();

        int b[] = new int[n2];

        System.out.print("Enter elements in sorted order: ");
        for(i = 0; i < n2; i++){
            b[i] = sc.nextInt();
        }

        int union[] = new int[n1 + n2];
        k = 0;

        for(i = 0; i < n1; i++){
            if(k == 0 || union[k - 1] != a[i]){
                union[k] = a[i];
                k++;
            }
        }

        for(i = 0; i < n2; i++){
            int flag = 0;

            for(j = 0; j < k; j++){
                if(union[j] == b[i]){
                    flag = 1;
                    break;
                }
            }

            if(flag == 0){
                union[k] = b[i];
                k++;
            }
        }

        for(i = 0; i < k; i++){
            System.out.print(union[i] + " ");
        }

        sc.close();
    }
}