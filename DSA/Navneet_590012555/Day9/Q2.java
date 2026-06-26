String removeSpaces(String s) {
    String r = "";
    for (char c : s.toCharArray())
        if (c != ' ') r += c;
    return r;
}