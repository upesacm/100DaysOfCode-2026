public class Question2 {

    public static void main(String[] args) {

        String str = "Hello";
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {

            char ch = Character.toLowerCase(str.charAt(i));

            if (ch != 'a' && ch != 'e' && ch != 'i' &&
                ch != 'o' && ch != 'u') {

                result.append('.');
                result.append(ch);
            }
        }

        System.out.println(result);
    }
}