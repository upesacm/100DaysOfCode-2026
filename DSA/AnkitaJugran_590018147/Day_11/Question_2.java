public class String_processing {
    public static void main(String[] args){
        String str = "HelloWorld";
        StringBuilder answer = new StringBuilder();

        for ( int i = 0 ; i < str.length() ; i++ ) {
            char ch = Character.toLowerCase(str.charAt(i));

            if ( ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ) {
                continue;
            }
            answer.append('.');
            answer.append(ch);
        }
        System.out.println(answer.toString());
    }
}
