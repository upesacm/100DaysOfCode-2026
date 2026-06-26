package DSA.MeghnaDhakad_590013960.Day_2;

public class Question2 {
    public static void main(String[] args){
        int[] arr = {3,7,9,2,5};
        int largest = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] > largest){
                largest = arr[i];
            }
        }
        System.out.println(largest);
    }
}
