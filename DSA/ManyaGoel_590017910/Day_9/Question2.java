import java.util.Scanner;
public class Question2{
    public static String remove_Spaces(String str){
        StringBuilder output=new StringBuilder();
        for (int i=0; i<str.length();i++){
            if(str.charAt(i)!= ' '){
                output.append(str.charAt(i));
            }
        }
    return output.toString();
    }
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a string: ");
    String str = sc.nextLine();
System.out.println("The string after removing spaces is: "+ remove_Spaces(str));
    sc.close();
}
}
