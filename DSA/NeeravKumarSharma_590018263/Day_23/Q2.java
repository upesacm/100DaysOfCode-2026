public class Q2 {
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }
    
    private String build(String str) {
        StringBuilder result = new StringBuilder();
        
        for (char c : str.toCharArray()) {
            if (c != '#') {
                result.append(c);
            } else if (result.length() > 0) {
                result.deleteCharAt(result.length() - 1);
            }
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        
        String s = "ab#c";
        String t = "ad#c";

        Q2 obj = new Q2();

        System.out.println(obj.backspaceCompare(s, t));
    }
}
