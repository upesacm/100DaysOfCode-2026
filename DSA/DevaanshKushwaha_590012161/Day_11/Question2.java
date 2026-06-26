public class RemoveVowelsAddDots {
    public static String transform(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c) && !"aeiouAEIOU".contains(String.valueOf(c))) {
                result.append('.').append(Character.toLowerCase(c));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(transform("Hello"));   // .h.l.l
        System.out.println(transform("Hello World")); // .h.l.l.w.r.l.d
        System.out.println(transform("AEIOU"));   // (empty)
        System.out.println(transform("Java"));    // .j.v
    }
}
