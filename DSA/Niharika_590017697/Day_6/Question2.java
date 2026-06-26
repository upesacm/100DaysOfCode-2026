import java.util.Scanner;
class Question2
{
    static void union(int[] arr1, int[] arr2, int n1, int n2)
    {
      int[] u=new int [n1+n2];
      int i=0, j=0, k=0;
      while(i<n1 && j<n2)
      {
        if(arr1[i]<arr2[j])
        {
            if(k==0 || u[k-1]!=arr1[i])
                u[k++]=arr1[i];
            i++;
        }
        else if(arr1[i]>arr2[j])
        {
          if(k==0 || u[k-1]!=arr2[j])
            u[k++]=arr2[j];
          j++;
        }
        else
        {
            if(k==0 || u[k-1]!=arr1[i])
              u[k++]=arr1[i];
            i++;
            j++;
        }
      }
      while(i<n1)
      {
        if(k==0 || u[k-1]!=arr1[i])
          u[k++]=arr1[i];
        i++;
      }
      while(j<n2)
      {
        if(k==0 || u[k-1]!=arr2[j])
          u[k++]=arr2[j];
        j++;
      }

      //print final array
      System.out.print("Union of array1 and array2: ");
      for(int p=0;p<k;p++)
      {
        System.out.print(" "+u[p]+" ");
      }
    }

    public static void main(String[] args) 
    {
      Scanner sc = new Scanner(System.in); 

      //input
      System.out.println("Enter size of array1: ");
      int n1=sc.nextInt();
      int[] arr1=new int[n1];
      System.out.println("Enter size of array2: ");
      int n2=sc.nextInt();
      int[] arr2=new int[n2];

      System.out.println("Enter elements of array 1: ");
      for(int i=0;i<n1;i++)
      {
         arr1[i]=sc.nextInt();
      }

      System.out.println("Enter elements of array 2: ");
      for(int i=0;i<n2;i++)
      {
         arr2[i]=sc.nextInt();
      }

      //union
      union(arr1, arr2, n1, n2);

      sc.close();
    }
}