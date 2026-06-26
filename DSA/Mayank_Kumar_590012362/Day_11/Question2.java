public class Question2 {
    public String solve(String s) {
        s = s.toLowerCase();
        StringBuilder r = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ("aeiouy".indexOf(c) == -1) r.append('.').append(c);
        } return r.toString();
    }
}