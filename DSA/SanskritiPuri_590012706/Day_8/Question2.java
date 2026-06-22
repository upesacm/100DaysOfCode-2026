public class Main {

    public static String reverseString(String s) {

        char[] arr = s.toCharArray();

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        return new String(arr);
    }

    public static void main(String[] args) {

        String s1 = "Computer";
        System.out.println(reverseString(s1));

        String s2 = "for";
        System.out.println(reverseString(s2));

        String s3 = "a";
        System.out.println(reverseString(s3));
    }
}
