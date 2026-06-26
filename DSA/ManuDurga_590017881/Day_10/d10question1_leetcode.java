package Day_10;

import java.util.Scanner;

public class d10question1_leetcode {
    public static int strStr(String haystack, String needle) {
        int in = haystack.indexOf(needle);
        return in;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();          //haystack input
        System.out.println("New Array");
        String s= sc.nextLine();          //needle input
        System.out.println(strStr(S,s));
        
    }}