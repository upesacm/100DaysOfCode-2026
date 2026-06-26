public class Main {

    public static String processString(String s) {

        StringBuilder result = new StringBuilder();

        s = s.toLowerCase();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch != 'a' && ch != 'e' && ch != 'i' &&
                ch != 'o' && ch != 'u' && ch != 'y') {

                result.append('.');
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        System.out.println(processString("Hello"));
        System.out.println(processString("Programming"));
        System.out.println(processString("aBAcAba"));
    }
}
