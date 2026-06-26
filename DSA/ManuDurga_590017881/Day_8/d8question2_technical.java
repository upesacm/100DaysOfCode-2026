package Day_8;

import java.util.Scanner;

public class d8question2_technical {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();          // size of the input array
        s = new StringBuilder(s).reverse().toString();
        System.out.println(s);
    }
}