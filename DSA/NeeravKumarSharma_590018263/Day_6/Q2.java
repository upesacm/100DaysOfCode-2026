import java.util.ArrayList;

class Q2 {
    public ArrayList<Integer> findUnion(int[] arr1, int[] arr2) {
        int i = 0, j = 0;
        ArrayList<Integer> union = new ArrayList<>();

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                if (union.isEmpty() || union.get(union.size() - 1) != arr1[i]) {
                    union.add(arr1[i]);
                }
                i++;
            } else {
                if (union.isEmpty() || union.get(union.size() - 1) != arr2[j]) {
                    union.add(arr2[j]);
                }
                j++;
            }
        }

        while (i < arr1.length) {
            if (union.get(union.size() - 1) != arr1[i]) {
                union.add(arr1[i]);
            }
            i++;
        }

        while (j < arr2.length) {
            if (union.get(union.size() - 1) != arr2[j]) {
                union.add(arr2[j]);
            }
            j++;
        }

        return union;
    }

    public static void main(String[] args) {
    
        int[] arr1 = {1, 2, 2, 3, 5};
        int[] arr2 = {2, 3, 4, 6}; 
        
        Q2 obj = new Q2();

        System.out.println(obj.findUnion(arr1, arr2));
    }
}