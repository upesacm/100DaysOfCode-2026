import java.util.*;
class union
{
    Public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n,m;
        System.out.println("Enter array size");
        n=sc.nextInt();
        m=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter"+(i+1)+"Elements");
            arr[i]=sc.nextInt();
        }
        int ar[]=new int[m];
        for(int i=0;i<m;i++)
        {
            System.out.println("Enter"+(i+1)+"elements");
            ar[i]=sc.nextInt();
        }
        int i=0,j=0;
        int lp=Integer.MIN_VALUE;
        
        while(i<n && j<m)
        {
            if(arr[i]<ar[j])
            {
                if(arr[i]!=lp)
                {
                    System.out.print(arr[i]+" ");
                    lp=arr[i];
                }
                i++;
            }
            else if(arr[i]> ar[j])
            {
                if(ar[j]!=lp)
                {
                    System.out.print(ar[j]+" ");
                    lp=ar[j];
                }
                j++;
            }
            else
            {
                if(arr[i]!=lp)
                {
                    System.out.print(arr[i]+" ");
                    lp=arr[i];
                }
                i++;
                j++;
            }
            }
        }
        while(i<n)
        {
            if(arr[i]!=lp)
            {
             System.out.print(arr[i]+" ");
             lp=arr[i];
            }
            i++;
        }
        while(j<m)
        {
            if(ar[j]!=lp)
            {
                System.out.print(ar[j]+" ");
                lp=ar[j];
            }
            j++;
        }
    }
