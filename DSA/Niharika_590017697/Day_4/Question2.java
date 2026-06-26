import java.util.Scanner;
class Question2
{
    static void reverse(int[] arr, int start, int end)
    {
        while(start<end)
        {
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        } 
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

       System.out.println("Enter number of times you want to rotate: ");
       int k=sc.nextInt();
       if(n==0)
        return;
       k=k%n;
       reverse(arr,0,n-1);
       reverse(arr,0,k-1);
       reverse(arr,k,n-1);

       System.out.println("array after rotation by "+k+" places");
       for(int i=0;i<n;i++)
       {
        System.out.print(arr[i]+" ");
       }
      
       sc.close();
    }
}


