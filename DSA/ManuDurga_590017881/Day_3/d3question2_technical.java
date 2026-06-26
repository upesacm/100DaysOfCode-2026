package Day_3;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

class d3question2_techical{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();          //this is the size of the input array
        int val = sc.nextInt();
        int k = 0;
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = sc.nextInt();}     //elements of that array
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == val) {
                k = k + 1;
            }
        }
        System.out.println(k);
        return;
}}
    