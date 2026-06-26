import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Question2 {
     public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Question2 obj = new Question2();
        System.out.println("Enter the size of array A :");
        int a=in.nextInt();
        System.out.println("Enter the size of array B :");
        int b=in.nextInt();
        int[] A = new int[a];
        System.out.println("Enter the Elements of array A:");
        for(int i=0;i<a;i++){
            A[i]=in.nextInt();
        }
        int[] B= new int[b];
        System.out.println("Enter the elements of array B: ");
        for(int i=0;i<b;i++){
            B[i]=in.nextInt();

        }
        System.out.println(obj.ArraysareEqual(A,B));
        in.close();



    }
    public boolean ArraysareEqual(int[] A, int[] B ){
        if (A .length != B.length)
            return false;

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : A)
            map.put(num, map.getOrDefault(num, 0) + 1);

        for (int num : B) {
            if (!map.containsKey(num))
                return false;

            map.put(num, map.get(num) - 1);

            if (map.get(num) == 0)
                map.remove(num);
        }

        return map.isEmpty();



    }
    
}
