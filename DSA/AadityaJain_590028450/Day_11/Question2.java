/*String Processing Task
Explanation
Modify a string by removing all vowels, converting consonants to lowercase, and adding a dot (.) before each consonant. */

import java.util.*;
public class Question2{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.next().toLowerCase();
        int i ;
        for(i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            if(ch != 'a' && ch != 'o' && ch != 'y' && ch != 'e' 
                && ch != 'u' && ch != 'i'){
                System.out.print("." + ch);
            }
        }
        sc.close();
    }
}