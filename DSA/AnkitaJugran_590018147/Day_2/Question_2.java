public class Largest_element {
    public static void main(String[] args) {

        int[] arr = {10,2,5,1,-1,0,3};
        if ( arr.length == 0 ){
            System.out.println("Array is empty");
            return;
        }
        
        int largest = arr[0];
        for ( int i = 1 ; i<arr.length ; i++ ) {
            if ( arr[i] > largest ){
                largest = arr[i];
            }
        }
        System.out.println("Largest element in the array is: " + largest);
    }
}
