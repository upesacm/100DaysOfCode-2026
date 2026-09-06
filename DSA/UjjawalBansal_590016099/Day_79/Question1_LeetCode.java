public class Question1_LeetCode {
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int c = 0;
        
        while (i >= 0|| j >= 0 || c != 0) {
            int sum = c;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            
            sb.append(sum % 2);
            c = sum / 2;
        }
        return sb.reverse().toString();
    }
}