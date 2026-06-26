import java.util.Scanner;
public class Question2 {
    public static String transform_string (String s){
        StringBuilder str=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = Character.toLowerCase(s.charAt(i));
            if(c!='a' && c!='e' && c!='i' && c!='o' && c!='u') str.append('.').append(c);
        }
    return str.toString();
    }
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the string:");
    String s=sc.nextLine();
    System.out.println("Transformed string is: "+transform_string(s));
    sc.close();
}
}