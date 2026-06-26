class Solution{
    public String compareGender (String s) {
        if (s.length() % 2 == 0 ){
            return "CHAT WITH HER!";

        }
        else {
            return "IGNORE HIM";
        }
}
}
public class Q2 {
    public static void main(String[] args) {
        String ex1 = "sevenkplus";
        Solution temp = new Solution();
        System.out.println(temp.compareGender(ex1));
    }
    
}
