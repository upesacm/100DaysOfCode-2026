import java.io.*;

public class Question2 {
    public static String encrypt(String s) {
        StringBuilder text = new StringBuilder(s.length());

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                text.append(s.charAt(i));
            }
        }
        int n = text.length();
        if (n == 0)  return "";
    
        int columns = (int) Math.ceil(Math.sqrt(n));
        StringBuilder result = new StringBuilder(n + columns);
    
        for (int col = 0; col < columns; col++) {
            if (col > 0) {
                result.append(' ');
            }
            for (int i = col; i < n; i += columns) {
                result.append(text.charAt(i));
            }
        }
        return result.toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the message to be encrypted:");
        String input = br.readLine();
        System.out.println("Original message: " + input);
        System.out.println("Encrypted message: " + encrypt(input));
    }
}