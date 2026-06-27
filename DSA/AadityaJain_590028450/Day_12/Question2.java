/* Smallest Distinct Window
Explanation
Find the length of the shortest substring that contains every distinct character present in the given string at least once.*/

import java.util.*;
public class Question2{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = sc.next();
        
        int i;
        int total[] = new int[300];
        int distinct = 0;

        for(i = 0; i < str.length(); i++){
            if(total[str.charAt(i)] == 0){
                distinct++;
            }

            total[str.charAt(i)]++;
        }

        int slide[] = new int[300];
        int count = 0;
        int j = 0;
        int ans = str.length();

        for(i = 0; i < str.length(); i++){

            if(slide[str.charAt(i)] == 0){
                count++;
            }

            slide[str.charAt(i)]++;

            while(count == distinct){

                ans = Math.min(ans, i - j + 1);

                slide[str.charAt(j)]--;

                if(slide[str.charAt(j)] == 0){
                    count--;
                }

                j++;
            }
        }

        System.out.println(ans);

        sc.close();
    }
}