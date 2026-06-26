/*
Rotate Array by K Steps
Explanation
Given an integer array and an integer k, rotate the array to the right by k steps.
*/

import java.util.*;
public class Question2{
    public static void main(String[] args){
        int i, j, k;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] a = new int[n];

        System.out.print("Enter the elements: ");
        for(i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        k = sc.nextInt();

        k = k % n;

        for(i = 0; i < k; i++){
            int temp = a[n - 1];

            for(j = n - 1; j > 0; j--){
                a[j] = a[j - 1];
            }

            a[0] = temp;
        }

        System.out.print("Rotated array: ");
        for(i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }

        sc.close();
    }
}