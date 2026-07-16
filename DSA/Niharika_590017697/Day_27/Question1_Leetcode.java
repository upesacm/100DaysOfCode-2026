class Solution {
    public int compress(char[] chars) {
        int idx = 0; 
        int i = 0;     
        while (i < chars.length) 
        {
            char currChar = chars[i];
            int count = 0;
            while (i < chars.length && chars[i] == currChar) 
            {
                i++;
                count++;
            }

            chars[idx++] = currChar;
            if (count > 1) 
            {
                String freq = String.valueOf(count);
                for (char c : freq.toCharArray()) 
                {
                    chars[idx++] = c;
                }
            }
        }
        return idx;
    }
}
