import java.util.HashMap;
import java.util.Scanner;

public class Question2 
{
    static boolean checkEqual(int[] arr1, int[] arr2) 
    {
        if (arr1.length != arr2.length) 
        {
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr1) 
        {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : arr2) 
        {
            if (!map.containsKey(num))
            {
                return false;
            }
            map.put(num, map.get(num) - 1);
            if (map.get(num) == 0) 
            {
                map.remove(num);
            }
        }
        return map.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array");
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        
        System.out.println("Enter elements of array 1: ");
        for (int i = 0; i < n; i++) 
        {
            arr1[i] = sc.nextInt();
        }

        System.out.println("Enter elements of array 2: ");
        for (int i = 0; i < n; i++) 
        {
            arr2[i] = sc.nextInt();
        }

        System.out.println("Output: "+checkEqual(arr1, arr2));

        sc.close();
    }
}
