import java.util.*;
class equalArray
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter first array size");
        int n=sc.nextInt();
        System.out.println("Enter second Array size");
        int m=sc.nextInt();
        if(m!=n)
        {
            System.out.println("Flase");
            return;
        }
        int arr[]=new int[n];
        int arr2[]=new int[m];
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter"+(i+1)+"Element:");
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<m;i++)
        {
            System.out.println("Enter"+(i+1)+"Element:");
            arr2[i]=sc.nextInt();
        }
        boolean isequal=true;
        for(int i=0;i<n;i++)
        {
            if(arr[i]!=arr2[i])
            {
                isequal=false;
                break;
            }
        }
        if(isequal)
        {
        System.out.println("True")
        }
        else
        {
            System.out.println("False");
        }
    }
}
