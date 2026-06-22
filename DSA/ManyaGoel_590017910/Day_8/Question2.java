import java.util.Scanner;
public class Question2 {
    public static String reverse_string(String s) {
        char[] arr= s.toCharArray();  
        int left=0;int right=s.length()-1;
        while (left < right){
            char temp= arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
    return new String(arr);
        
    }
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the string to be reversed:");
    String s=sc.nextLine();
    System.out.println("Reversed string: "+ reverse_string(s));
    sc.close();  
}
}
