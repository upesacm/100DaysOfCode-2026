public class Q2 {
    public void modifyString(String s) {
        StringBuilder result = new StringBuilder();
        String vowels = "aeiouAEIOU";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isLetter(c) && vowels.indexOf(c) == -1) {
                result.append('.');
                result.append(Character.toLowerCase(c));
            }
        }

        System.out.println(result.toString());
    }

    public static void main(String[] args) {
        Q2 obj = new Q2();
        
        System.out.println("Input: Hello");
        System.out.print("Output: ");
        obj.modifyString("Hello"); 
    }
}
