package Day_9;

import java.util.Scanner;

public class d9question1_leetcode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();          // size of the input array
        int sLength = s.length();
        int wlen = 0;
        for(int i = 0; i<sLength;i++){
            if(s.charAt(sLength-i-1)==' '&&wlen==0){continue;}
            else if(s.charAt(sLength-i-1)==' '){
                System.out.println(wlen);
                return;}
            else{wlen++;}
        }
    return;
    }}