import java.util.Scanner;

public class Question {
    static int countOccurence(int[] arr, int target){
        int count = 0;
        for (int i = 0; i<arr.length; i++){
            if(arr[i] == target){
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int num = sc.nextInt();
        int[] arr = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        System.out.println(countOccurence(arr, target));

        sc.close();
    }
}
