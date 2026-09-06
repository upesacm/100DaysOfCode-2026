class Solution {
    public String encryption(String s) {
        s = s.replaceAll(" ", "");
        int n = s.length(), r = (int)Math.sqrt(n), c = r;
        if (r * c < n) c++;
        if (r * c < n) r++;

        StringBuilder a = new StringBuilder();
        for (int j = 0; j < c; j++) {
            if (j > 0) a.append(" ");
            for (int i = 0; i < r; i++) {
                int k = i * c + j;
                if (k < n) a.append(s.charAt(k));
            }
        }
        return a.toString();
    }
}