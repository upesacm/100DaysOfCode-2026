import java.util.*;
class greedy
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of array");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the array elements");
        for(int i=0 ; i<n ; i++)
        {
            arr[i]=sc.nextInt();
        }
        int left=0;
        int right=arr.length-1;
        int p1=0;
        int p2=0;
        boolean turn=true;

        while(left <= right)
        {
            int picked;
            if(arr[left] >= arr[right])
            {
                picked=arr[left];
                left++;
            }
            else
            {
                picked=arr[right];
                right--;
            }
            if(turn)
            {
                p1 += picked;
            }
            else
            {
                p2 += picked;
            }
            turn= !turn;
        }
        System.out.println(p1 + " " + p2);
    }
}