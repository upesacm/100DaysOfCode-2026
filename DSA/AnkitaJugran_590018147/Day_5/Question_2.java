import java.util.Arrays;


public class Equal_arr {
    public static void main(String[] args) {
        int[] arr1 = {10,2,5,8,0};
        int[] arr2 = {0,5,10,8,2};

            if(arr1.length != arr2.length) {
            System.out.println("Arrays are not equal");
            return;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for ( int i = 0 ; i < arr1.length ; i++ )  {
            if( arr1[i] != arr2[i]){
                System.out.println("Arrays are not equal");
                return;
                }
                
            }
            System.out.println("Arrays are equal");

    }
}