package Day_31;

import java.util.*;
public class d31question1_leetcode {
    
    public static int[] finalPrices(int[] prices) {
        for(int i =0;i<prices.length;i++){
            for(int j =i+1;j<prices.length;j++){
                if(prices[i]>=prices[j]){prices[i]-=prices[j];
                break;}
            }
        }
        return prices;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size of Array: ");
        int n = sc.nextInt();
        int[] Arr = new int[n];
        for(int i=0;i<n;i++){
            System.out.print(": ");
            Arr[i]=sc.nextInt();
        }
        System.out.println(Arrays.toString(finalPrices(Arr)));
        sc.close();
    }
}
