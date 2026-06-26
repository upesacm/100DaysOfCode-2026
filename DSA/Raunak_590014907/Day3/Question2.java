
public class Question2 {

    public int count(int[] arr,int k) {

        int count =0;

        for(int i = 0; i < arr.length; i++) {
        if (arr[i]==k)
            count+=1;
        }
        return count;
    }
}
