import java.util.Arrays;

class Q2 {
    public boolean areEqual(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        
        int[] arr1 = {1,2,8,7};
        int[] arr2 = {7,2,8,1};

        Q2 obj = new Q2();

        System.out.println(obj.areEqual(arr1, arr2));
    }
}