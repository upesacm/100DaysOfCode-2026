class Question1_LeetCode {
    public int compress(char[] chars) {
        int len = chars.length;
        int j = 0;

        for (int i = 0; i < len; i++) {
            int count = 1;
            
            while (i + 1 < len && chars[i] == chars[i + 1]) {
                i++;
                count++;
            }
            
            chars[j++] = chars[i];
            
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[j++] = c;
                }
            }
        }
        return j;
    }
}