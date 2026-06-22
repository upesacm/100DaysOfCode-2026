class Q2 {
    public void reverseString(String s) {
        char[] characters = s.toCharArray();
        int left = 0;
        int right = characters.length - 1;
        
        while (left < right) {
            char temp = characters[left];
            characters[left] = characters[right];
            characters[right] = temp;
            
            left++;
            right--;
        }

        String reversed = new String(characters);
        System.out.println(reversed);
    }

    public static void main(String[] args) {
        
        String str = "100 Days of Code";

        Q2 obj = new Q2();

        System.out.println("Original String: "+str);
        System.out.print("Reversed String: ");
        obj.reverseString(str);
    }
}