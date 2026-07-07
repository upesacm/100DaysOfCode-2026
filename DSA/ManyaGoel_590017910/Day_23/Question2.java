import java.util.Scanner;
public class Question2 {
    public static boolean CompareBackspace(String s, String t){
        int i=s.length()-1; // Initialize pointer for string s to the last character
        int j=t.length()-1; // Initialize pointer for string t to the last character
        
        while(i >=0 || j >= 0){
            int backspaceCount=0; // Initialize a counter for backspaces in string s
            while(i >= 0 && (s.charAt(i)=='#' || backspaceCount > 0)){
                if(s.charAt(i)=='#'){
                    backspaceCount++; // Increment the backspace counter if a '#' is encountered
                }else{
                    backspaceCount--; // Decrement the backspace counter if a valid character is encountered
                }
                i--; // Move the pointer to the left in string s
            }
            backspaceCount=0; // Reset the backspace counter for string t
            while(j >= 0 && (t.charAt(j)=='#' || backspaceCount > 0)){
                if(t.charAt(j)=='#'){
                    backspaceCount++; // Increment the backspace counter if a '#' is encountered
                }else{
                    backspaceCount--; // Decrement the backspace counter if a valid character is encountered
                }
                j--; // Move the pointer to the left in string t
            }
            char charS=(i >= 0) ? s.charAt(i) : '\0'; // Get the current character from string s or null character if out of bounds
            char charT=(j >= 0) ? t.charAt(j) : '\0'; // Get the current character from string t or null character if out of bounds
            if(charS != charT){ // Compare the characters from both strings
                return false; // Return false if they are not equal
            }
            i--; // Move to the next character in string s
            j--; // Move to the next character in string t
        }
        return true; // Return true if both strings are equal after processing backspaces
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the first string:");
        String s=sc.nextLine();
        System.out.println("Enter the second string:");
        String t=sc.nextLine();
        boolean result=CompareBackspace(s,t);
        if(result){
            System.out.println("True: Both strings are equal after processing backspaces.");
        }else{
            System.out.println("False: Both strings are not equal after processing backspaces.");
        }
        sc.close();
    }
}