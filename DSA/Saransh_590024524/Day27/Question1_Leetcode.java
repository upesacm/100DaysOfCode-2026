class Solution {
    public int compress(char[] chars) {
        int i,j;
        char c;
        int write = 0;
        for(i=0;i<chars.length;i++)
        {
            c = chars[i];
            for (j=i ; j<chars.length ; j++)
            {
                if(chars[j] != chars[i])
                    break;
            }
            int n = j-i;
            chars[write++] = c; 
            if (n > 1)
            {
                String s = Integer.toString(n);
                for (int k = 0; k< s.length(); k++) {
                    chars[write++] = s.charAt(k);
                }
            } 
        i = j - 1;        
        }
        return write;
    }
}