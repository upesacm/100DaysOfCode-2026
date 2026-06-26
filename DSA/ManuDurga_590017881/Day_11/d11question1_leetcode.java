package Day_11;

import java.util.Arrays;
import java.util.Scanner;

public class d11question1_leetcode {
        public static int[] commonArray(String S) {
        int[] Sresult = new int[S.length()];
        boolean[] seen = new boolean[256];

        int[] firstIndex = new int[256];

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if (!seen[c]) {
                firstIndex[c] = i;
                seen[c] = true;
            }

            Sresult[i] = firstIndex[c];}
        return Sresult;}
        
         public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine(); 
        System.out.println("New String");
        String s = sc.nextLine(); 
        if(Arrays.toString(commonArray(s)).equals(Arrays.toString(commonArray(S)))){System.out.println("True");}
        else{System.out.println("False");}
    }}
