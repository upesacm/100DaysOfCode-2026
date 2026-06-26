class Solution {
    public String removeSpace (String s ){
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < s.length(); i++ ){
            if (s.charAt(i)!=' '){
                sb.append(s.charAt(i));

            }
        }
        return sb.toString();


    }
}

public class Q2 {
    public static void main(String[] args) {
        String example1 = "C oding";
        String example2 = "abc d";
        Solution temp = new Solution();
        System.out.println(temp.removeSpace(example1));
        System.out.println(temp.removeSpace(example2));

        
    }
    
}