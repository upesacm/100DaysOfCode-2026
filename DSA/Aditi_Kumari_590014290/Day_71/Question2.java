package DSA.Aditi_Kumari_590014290.Day_71;

import java.util.*;

public class Question2 {
    static String encryption(String s) {
        s = s.replace(" ", "");
        int n = s.length();
        int rows = (int) Math.floor(Math.sqrt(n));
        int cols = (int) Math.ceil(Math.sqrt(n));
        if (rows * cols < n) {
            rows++;
        }
        StringBuilder result = new StringBuilder();

        for (int col = 0; col < cols; col++) {
            if (result.length() > 0) {
                result.append(" ");
            }

            for (int row = 0; row < rows; row++) {
                int index = row * cols + col;

                if (index < n) {
                    result.append(s.charAt(index));
                }
            }
        }

        return result.toString();
    }
}