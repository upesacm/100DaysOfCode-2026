import java.util.Scanner;
public class Question2 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt(); 

        int left = 0;
        int right = n - 1;
        int p1 = 0;
        int p2 = 0;
        boolean firstTurn = true;

        while (left <= right) 
        {
            int pick;
            if (arr[left] > arr[right]) 
            {
                pick = arr[left];
                left++;
            } 
            else 
            {
                pick = arr[right];
                right--;
            }

            if (firstTurn)
                p1 += pick; 
    
            else
                p2 += pick; 

            firstTurn = !firstTurn;
        }
        System.out.println(p1 + " " + p2);

        sc.close();
    }
}
