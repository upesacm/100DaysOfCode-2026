import java.util.Scanner;
class Question2
{
    static int sum(int[] arr, int n)
    {
        int sum=0;
      for(int i=0;i<n;i++)
      {
        sum+=arr[i];
      }
      return sum;
    }

    public static void main(String[] args) 
    {
      Scanner sc = new Scanner(System.in); 

      //input
      System.out.println("Enter size of array: ");
      int n=sc.nextInt();
      int[] arr=new int[n];
      System.out.println("Enter array elements: ");
      for(int i=0;i<n;i++)
      {
         arr[i]=sc.nextInt();
      }

      System.out.println("Sum: " + sum(arr,n));      

      sc.close();
    }
}
