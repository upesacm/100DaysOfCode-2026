class Question2 {
    public static String remove(String s) {
        char[] arr = s.toCharArray();
        int i = 0; 
        for (int j = 0; j < arr.length; j++) 
            if (arr[j] != ' ') 
                arr[i++] = arr[j];
        return new String(arr, 0, i);
    }
}