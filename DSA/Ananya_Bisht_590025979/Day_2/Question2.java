import java.util.Scanner;
public class Question2 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        if(n==0)
            return;

        for (int i = 0; i < n; i++) 
        {
            arr[i] = sc.nextInt();

        }

        int max=arr[0];
        for(int i=1;i<n;i++)
        {
            if(arr[i]>max)
                max=arr[i];
        }

        System.out.println("output: "+max);

        sc.close();
    }
}

