class Solution {
    public static int[] cardGame (int [] arr){
        int left = 0;
        int right = arr.length-1;
        int [] result = new int [2];
        for (int i = 0 ; i <arr.length ; i++ ) {
            if (i%2!=0) {
                if (arr[left]>arr[right]) {
                    result[0] = result[0]+ arr[left];
                    left++;
                    
                }
                else {
                    result[0] = result[0] + arr[right];
                    right--;

                }
               
            }
            else {
                if (arr[left]>arr[right]) {
                    result[1] = result[1]+ arr[left];
                    left++;
                }
                else {
                    result[1] = result[1] + arr[right];
                    right--;
                }
             

            }
            
        }
        return result;


    }
}


public class Q2 {
    public static void main(String[] args) {
        int [] arr1 = {4,1,2,10};
        int [] arr2 = {1,2,3,4,5,6,7};
        int [] result_1 = Solution.cardGame(arr1);
        int [] result_2 = Solution.cardGame(arr2);
        System.out.println("First: " +result_1[0]);
        System.out.println("Second: " +result_1[1]);

        System.out.println("First: " +result_2[0]);
        System.out.println("Second: " +result_2[1]);



    }
}