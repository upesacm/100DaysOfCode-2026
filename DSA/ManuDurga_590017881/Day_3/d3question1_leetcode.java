package Day_3;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

class d3question1_leetcode{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();          //this is the size of the input array
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = sc.nextInt();}     //elements of that array
        
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] = digits[i]+1;
                System.out.println(Arrays.toString(digits));
                return;
            }
            else{
            digits[i] = 0;}
        }
        
        int[] copy = new int[digits.length + 1];
        copy[0] = 1;
        System.out.println(Arrays.toString(copy));
        return;
    }
}
    