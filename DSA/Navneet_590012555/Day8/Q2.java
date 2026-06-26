String reverse(String s) 
{
    String r = "";
    for (int i = s.length() - 1; i >= 0; i--)
        r += s.charAt(i);
    return r;
}
