
import java.util.*;
public class Question2 {
     public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter the size of First Array: ");
            int m=in.nextInt();
            int[] a =new int[m];
            System.out.println("Enter the elements of the first array: ");
            for(int i=0;i<m;i++){
                a[i]=in.nextInt();
            }
            System.out.println("Enter the size of the second array: ");
            int n=in.nextInt();
            int[] b = new int[n];
            System.out.println("Enter the elements of the second array: ");
            for(int i=0;i<n;i++){
                b[i]=in.nextInt();
            }

            System.out.println(UsingTwoPointers(a, b));
            in.close();
        }

        public static ArrayList<Integer> UsingTwoPointers(int[] a, int[] b) {

            int m = a.length;
            int n = b.length;

            int i = 0;
            int j = 0;

            ArrayList<Integer> list = new ArrayList<>();

            while(i < m && j < n){

                if(a[i] < b[j]){
                    if(list.isEmpty() || list.get(list.size()-1) != a[i]){
                        list.add(a[i]);
                    }
                    i++;
                }
                else if(a[i] > b[j]){
                    if(list.isEmpty() || list.get(list.size()-1) != b[j]){
                        list.add(b[j]);
                    }
                    j++;
                }
                else{
                    if(list.isEmpty() || list.get(list.size()-1) != a[i]){
                        list.add(a[i]);
                    }
                    i++;
                    j++;
                }
            }

            while(i < m){
                if(list.isEmpty() || list.get(list.size()-1) != a[i]){
                    list.add(a[i]);
                }
                i++;
            }

            while(j < n){
                if(list.isEmpty() || list.get(list.size()-1) != b[j]){
                    list.add(b[j]);
                }
                j++;
            }

            return list;

    }
} 
