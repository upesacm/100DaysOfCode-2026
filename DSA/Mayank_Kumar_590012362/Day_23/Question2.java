public class Question2 {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder a = new StringBuilder(), b = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (a.length() > 0)  a.deleteCharAt(a.length() - 1);
            } else a.append(c);
        }
        for (char c : t.toCharArray()) {
            if (c == '#') {
                if (b.length() > 0) b.deleteCharAt(b.length() - 1);
            } else b.append(c);
        } 
        return a.toString().equals(b.toString());
    }
}