/* Remove Spaces from String
Explanation
Remove all spaces from a string and print the modified string */

import java.util.*;
public class Question2{
    public static void main(String[] args){
        
        int i;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        StringBuilder sb = new StringBuilder();

        for(i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            if(ch != ' '){
                sb.append(ch);
            }
        }

        System.out.println(sb);
        sc.close();
    }
}