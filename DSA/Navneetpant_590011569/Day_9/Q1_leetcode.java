class Solution {
    public int lengthOfLastWord(String s) {
        StringBuilder sb = new StringBuilder(); 
        int i = s.length()-1 ;
        while (i>=0 && s.charAt(i)== ' '){
            i--;
        }
        
        for (; i >=0 ; i-- ) {
            if ( s.charAt(i) != ' '){      
            sb.append(s.charAt(i));
            }
            else {
                break;
            }
            

        }
        return sb.length();
        
    }
}