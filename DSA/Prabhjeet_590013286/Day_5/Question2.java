public class Question2 {

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {1, 2, 3, 4};

        int n1 = arr1.length;
        int n2 = arr2.length;

        boolean equal = true;

        if (n1 != n2) { // Arrays of different sizes cannot be equal

            equal = false;
        }
        else {

            for (int i = 0; i < n1; i++) {

                if (arr1[i] != arr2[i]) { // Mismatch found

                    equal = false;
                    break;
                }
            }
        }

        System.out.println(equal ? "True" : "False");
    }
}