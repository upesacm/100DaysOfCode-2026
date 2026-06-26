public class ReverseString {
    
    public static String reverse(String s) {

        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
        String input = "Mouli";
        String reversed = reverse(input);
        
        System.out.println("Original: " + input);
        System.out.println("Reversed: " + reversed);
  
    }
}
