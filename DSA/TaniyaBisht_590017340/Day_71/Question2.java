
import java.util.*;
class GE{
    public static String encryption(String s) {
        s = s.replaceAll("\\s+", "");
        int length = s.length();
        int rows = (int) Math.sqrt(length);
        int columns = rows;
        if (rows * columns < length) {
            columns++;
        }
        if (rows * columns < length) {
            rows++;
        }
        StringBuilder result = new StringBuilder();
        for (int col = 0; col < columns; col++) {
            if (result.length() > 0) {
                result.append(" ");
            }
            for (int row = 0; row < rows; row++) {
                int index = row * columns + col;
                if (index < length) {
                    result.append(s.charAt(index));
                }
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String s = "have a nice day";
        System.out.println(encryption(s));
    }
}