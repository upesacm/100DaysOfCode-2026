class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 ){
            return 0;
        }
        HashSet <Character> hs = new HashSet<>();
        int l = 0;
        int maxLength = 0;

        for (int i = 0 ; i < s.length() ; i++ ) {
            while (hs.contains(s.charAt(i))){
                hs.remove(s.charAt(l));
                l++;
            }

            hs.add(s.charAt(i));

            maxLength = Math.max(maxLength, i-l+1);



        }
        return maxLength;

    }
}
        
