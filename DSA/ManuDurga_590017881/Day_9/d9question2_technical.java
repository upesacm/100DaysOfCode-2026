package Day_9;

import java.util.Scanner;

public class d9question2_technical {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();          // size of the input array
            s = s.replaceAll("[^A-Za-z0-9]", "");
        System.out.println(s);
    }}