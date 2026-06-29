import java.util.*;
public class Question2 {
    public static void findUnion(int[] a,int[] b){
        int i = 0, j = 0;
        while(i < a.length && j < b.length){
            if(i > 0 && a[i] == a[i-1]){
                i++;
                continue;
            }
            if(j > 0 && b[j] == b[j-1]){
                j++;
                continue;
            }
            if(a[i] <= b[j]){
                System.out.print(a[i] + " ");
                if(a[i] == b[j]){
                    j++;
                }
                i++;
            }else{
                System.out.print(b[j] + " ");
                j++;
            }
        }
        while(i < a.length){
            if(i == 0 || a[i] != a[i-1]){
                System.out.print(a[i] + " ");
            }
            i++;
        }
        while(j < b.length){
            if(j == 0 || b[j] != b[j-1]){
                System.out.print(b[j] + " ");
            }
            j++;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n;i++){
            a[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] b = new int[m];
        for(int i = 0; i < m;i++){
            b[i] = sc.nextInt();
        }
        findUnion(a,b);
    }
}
