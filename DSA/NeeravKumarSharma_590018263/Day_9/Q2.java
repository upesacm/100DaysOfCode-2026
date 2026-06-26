class Q2 {
    public void removeSpaces(String s) {
        StringBuilder modifiedStr = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            
            if (currentChar != ' ') {
                modifiedStr.append(currentChar);
            }
        }
        
        System.out.println(modifiedStr.toString());
    }

    public static void main(String[] args) {
        Q2 obj = new Q2();
        
        String testStr = "100 Days of Code";
        
        System.out.print("Original: ");
        System.out.println(testStr);
        
        System.out.print("Modified: ");
        obj.removeSpaces(testStr);
    }
}

/*class Q2 {
    public void removeSpaces(String s) {
        String modifiedString = s.replaceAll(" ", "");
        
        System.out.println(modifiedString);
    }

    public static void main(String[] args) {
        Q2 obj = new Q2();
        
        String testStr = "100 Days of Code";
        
        System.out.print("Original: ");
        System.out.println(testStr);
        
        System.out.print("Modified: ");
        obj.removeSpaces(testStr);
    }
}*/