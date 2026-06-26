package Day_11;

import java.util.Scanner;

public class d11question2_technical {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();  //String input
        s=s.toLowerCase();
        s= s.replaceAll("a","").replaceAll("u","").replaceAll("o","").replaceAll("i","").replaceAll("e","");
        s=s.replaceAll(".", ".$0");
        System.out.println(s);
    }}