package Day_9;
import java.util.*;

public class Question2 {
    public static void main(String[] args){
        Scanner scan= new Scanner(System.in);
        System.out.print("Enter the string:");
        String s=scan.nextLine(); 
        String result= "";
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) != ' '){
                result+= s.charAt(i);
            }
        }
        System.out.println(result); 
        scan.close(); 
    }
    
}
