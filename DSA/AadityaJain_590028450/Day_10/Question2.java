/*Determine Gender
Explanation
Count distinct characters in a string and print "CHAT WITH HER!" if even, "IGNORE HIM!" if odd. */

import java.util.*;
public class Question2{
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.next();
        
        int i, j;
        int dis= 0;
        int flag = 0;

        for(i = 0; i < s.length(); i++){
            flag = 0;

            for(j = 0; j < i; j++){
                if(s.charAt(i) == s.charAt(j)){
                    flag = 1;
                    break;
                }
            }

            if(flag == 0){
                dis++;
            }
        }

        if(dis % 2 == 0){
            System.out.println("CHAT WITH HER!");
        }
        else{
            System.out.println("IGNORE HIM!");
        }

        sc.close();

    }
}