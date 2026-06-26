class Q2 {
    public String modify(String s) {
        String r = "";

        for (char c : s.toCharArray()) {
            c = Character.toLowerCase(c);
            if ("aeiouy".indexOf(c) == -1)
                r += "." + c;
        }

        return r;
    }
}