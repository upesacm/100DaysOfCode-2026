import java.util.Scanner;
class Question1_Leetcode
{
    static int search(int[] arr,int n)
    {
      int totalSum=(n*(n+1))/2;
      int sum=0;
      for(int i=0;i<n;i++)
      {
        sum+=arr[i];
      }
      return totalSum-sum;
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

      System.out.println("Missing element is: " + search(arr,n));      

      sc.close();
    }
}
