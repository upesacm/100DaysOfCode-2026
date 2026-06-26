import java.util.*;
class main
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Array Size");
        int numssize=sc.nextInt();

        int arr[]=new int[numssize];
        for(int i=0;i<numssize;i++)
        {
            System.out.print("Enter"+(i+1)+"Element:");
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter value of k");
        int k=sc.nextInt();

        k=(k%numssize+numssize)%numssize;

        int ar[]=new int[numssize];

        for(int i=0;i<numssize;i++)
        {
            int newpos=(i+k)%numssize;
            ar[newpos]=arr[i];
        }
        System.out.println("Rotated Array");
        for(int i=0;i<numssize;i++)
        {
            System.out.print(ar[i]+"\t");
        }
    }
}