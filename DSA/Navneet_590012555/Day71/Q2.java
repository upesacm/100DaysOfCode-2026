class Solution {
    public String encryption(String s) {
        s = s.replace(" ", "");

        int n = s.length();
        int r = (int) Math.sqrt(n);
        int c = r;

        if (r * c < n)
            c++;

        if (r * c < n)
            r++;

        StringBuilder ans = new StringBuilder();

        for (int j = 0; j < c; j++) {
            for (int i = 0; i < r; i++) {
                int x = i * c + j;

                if (x < n)
                    ans.append(s.charAt(x));
            }

            ans.append(" ");
        }

        return ans.toString().trim();
    }
}