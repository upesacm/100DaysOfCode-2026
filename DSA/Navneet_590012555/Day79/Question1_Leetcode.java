class Solution {
    public String addBinary(String a, String b) {
        String ans = "";
        int i = a.length() - 1;
        int j = b.length() - 1;
        int c = 0;

        while (i >= 0 || j >= 0 || c > 0) {
            int sum = c;

            if (i >= 0)
                sum += a.charAt(i--) - '0';

            if (j >= 0)
                sum += b.charAt(j--) - '0';

            ans = (sum % 2) + ans;
            c = sum / 2;
        }

        return ans;
    }
}
