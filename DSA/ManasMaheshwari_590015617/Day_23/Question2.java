class Question2 {
    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ad#c";
        
        System.out.println(process(s).equals(process(t)));
    }
    
    public static String process(String str) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != '#') {
                sb.append(c);
            } else if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        
        return sb.toString();
    }
}
