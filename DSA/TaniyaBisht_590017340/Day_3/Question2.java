
class Occ{
    public static void main(String[] args){
        int[] arr = {0,2,6,6,6};
        int target = 6;
        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == target){
                count++;
            }
        }
        System.out.println("Number of occurrences of the target value 6 is: "+count);
    }
}