package Day_8;

import java.util.Scanner;

public class d8question1_leetcode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();          // size of the input array
        s=s.toLowerCase();
        s = s.replaceAll("[^A-Za-z0-9]", "");
        String reverse = new StringBuilder(s).reverse().toString();
        // System.out.println(reverse);
        // System.out.println(s);
        if(reverse.equals(s)){System.out.println(true);}else{
        System.out.println(false);}
    }
}