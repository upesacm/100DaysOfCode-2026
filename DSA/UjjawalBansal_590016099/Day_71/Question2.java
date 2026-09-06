import java.util.Scanner;

public class Question2 {
    public static String gridEncryption(String s) {
        String text = s.replaceAll(" ", "");
        int len = text.length();
        
        if (len == 0) {
            return "";
        }

        int r1 = (int) Math.floor(Math.sqrt(len));
        int r2 = (int) Math.ceil(Math.sqrt(len));
        
        int c1 = (int) Math.ceil((double) len / r1);
        int c2 = (int) Math.ceil((double) len / r2);
        
        int rows, columns;
        if (r1 * c1 <= r2 * c2) {
            rows = r1;
            columns = c1;
        } 
        else {
            rows = r2;
            columns = c2;
        }

        StringBuilder ans = new StringBuilder();
        
        for (int c = 0; c < columns; c++) {
            for (int r = 0; r < rows; r++) {
                int index = r * columns + c;
                if (index < len) {
                    ans.append(text.charAt(index));
                }
            }
            
            if (c < columns - 1) {
                ans.append(" ");
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the text: ");
        String s = sc.nextLine();
        String result = gridEncryption(s);
        System.out.println("Encrypted message:");
        System.out.println(result);
        sc.close();
    }
}