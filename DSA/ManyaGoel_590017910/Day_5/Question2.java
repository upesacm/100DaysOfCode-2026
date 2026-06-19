import java.util.HashMap;
import java.util.Scanner;
public class Question2 {
    public static boolean checkarrays(int []a ,int []b){
        HashMap <Integer,Integer> map =new HashMap<>();
        for (int i:a){ map.merge(i,1,Integer::sum);}
        for (int j:b){map.merge(j,-1,Integer::sum);}
        for (int value :map.values()){
            if (value!=0){
                return false;
            }           
            }
            return true;
        }
    public static void main (String []args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the arrays:");
        int n=sc.nextInt();
        int[] a=new int[n];
        int[] b=new int[n];
        System.out.println("Enter the elements of the first array:");
        for (int i=0;i<n;i++){a[i]=sc.nextInt();}       
        System.out.println("Enter the elements of the second array:");
        for (int i=0;i<n;i++){b[i]=sc.nextInt();}
        System.out.println(checkarrays(a,b));
        sc.close();
    }    
}

