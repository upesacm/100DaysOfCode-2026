
import java.util.*;
class Arrayeq{
    public static void main(String[] args) {
        int[] arr1 = {7,4,2,0};
        int[] arr2 = {7,4,0,2};
        boolean eq = true;
        if(arr1.length != arr2.length){
            eq = false;
        }
        else{
            for(int i=0; i<arr1.length; i++){
                if(arr1[i] != arr2[i]){
                    eq = false;
                    break;
                }
            }
        }
        System.out.print(eq);
    }
}