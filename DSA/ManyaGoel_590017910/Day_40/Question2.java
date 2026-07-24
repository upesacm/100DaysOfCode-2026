import java.util.*;
public class Question2 {
    public static int[] MaxTemperature(int[] temp, int k){

        if(temp == null || temp.length == 0 || k == 0){
            return new int[0];
        }
        Deque <Integer> window = new ArrayDeque<>();
        int[] result =  new int[ temp.length - k + 1];
        int index = 0;
        for ( int i = 0 ; i < temp.length ; i++){
            while ( ! window.isEmpty() && window.peekFirst() <= i-k ) {
                window.pollFirst();
            }
            while ( ! window.isEmpty() && temp[window.peekLast()] <= temp[i]){
                window.pollLast();
            }
            window.offerLast(i);
            if (i >= k - 1) {
                result[index] = temp[window.peekFirst()];
                index++;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of temperature readings: ");
        int n = sc.nextInt();
        int[] temp = new int[n];

        System.out.println("Enter the temperature readings:");
        for (int i = 0; i < n; i++) {
            temp[i] = sc.nextInt();
        }

        System.out.print("Enter window size (k): ");
        int k = sc.nextInt();
        int[] result = MaxTemperature(temp, k);
        System.out.println("Result array:" + Arrays.toString(result));
        sc.close();
    }
}