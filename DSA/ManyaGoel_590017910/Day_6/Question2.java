import java.util.Arrays;
import java.util.Scanner;
public class Question2 {
    static int[]  merge(int[] a, int[] b){
        int m=a.length; int n=b.length;
        int[] c=new int[m+n]; 
        int i=0; int j=0; int k=0;
        while( i<m && j<n){
            if (a[i]<b[j]) c[k++]=a[i++];
            else if (a[i]>b[j]) c[k++]=b[j++];
            else {
                c[k++]=a[i++];
                j++;
            }
        }
        while (i<m){
            c[k++]=a[i++];
        }
        while (j<n){
            c[k++]=b[j++];
        }
        return Arrays.copyOf(c, k);  
    }
    static void array_union(int[] c){
        System.out.println("Union of the two arrays:");
        System.out.print("[");
         if(c.length > 0){
        System.out.print(c[0]);
        }
        for (int i=1;i<c.length;i++){
            if (c[i]!=c[i-1]){
                System.out.print(", "+c[i]);
            }
        }        System.out.println("]");
    }
    public static void main (String []args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array 1:");
        int m=sc.nextInt();
        System.out.println("Enter the size of the array 2:");
        int n=sc.nextInt();
        int[] a=new int[m];
        int[] b=new int[n];
        System.out.println("Enter the elements of the first array:");
        for (int i=0;i<m;i++){a[i]=sc.nextInt();}       
        System.out.println("Enter the elements of the second array:");
        for (int i=0;i<n;i++){b[i]=sc.nextInt();}
        int[] c=merge(a,b);
        array_union(c);
        sc.close();
    }
    }
