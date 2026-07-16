
class Solution {
    public int compress(char[] chars) {
        int j= 0;
        int i = 0;
        while (i < chars.length) {
            char current = chars[i];
            int count = 0;
            while (i < chars.length && chars[i] == current) {
                i++;
                count++;
            }
            chars[j++] = current;
            if (count > 1) {
                String str = Integer.toString(count);
                for (char c : str.toCharArray()) {
                    chars[j++] = c;
                }
            }
        }
        return j;
    }
}