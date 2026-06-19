package Day_4;

public class Question_2 {
    public void rotate(int[]arr, int k){
        int len=arr.length;
        k=k%len;
        rev(arr,0,len-1);
        rev(arr,0,k-1);
        rev(arr,k,len-1);
    }
    public void rev(int[]arr,int left,int right){
        while (left<right){
            int temp= arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left+=1;
            right-=1;
        }
    }
    
}
