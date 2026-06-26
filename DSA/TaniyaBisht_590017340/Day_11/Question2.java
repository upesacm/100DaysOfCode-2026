
class Pro{
    public static void main(String[] args) {
        String str = "SoAmerican";
        String r= "";
        for(int i=0; i<str.length(); i++) {
            char ch = Character.toLowerCase(str.charAt(i));
            if (ch != 'a' && ch != 'e' && ch != 'i' &&
                ch != 'o' && ch != 'u' && ch != 'y') {
                r= r + "." + ch;
            }
        }
        System.out.println(r);
    }
}