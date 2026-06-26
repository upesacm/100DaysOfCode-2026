// Question: Given two sorted arrays, find the union of the arrays containing all distinct elements.
// Time Complexity: O(N + M)
// Space Complexity: O(N + M)

class Question2 {
    public static void main(String args[]) {
        int arr1[] = {1, 2, 3, 4, 5};
        int arr2[] = {1, 2, 3, 6, 7};
        
        int count1 = arr1.length;
        int count2 = arr2.length;
        
        // Create a standard array big enough to hold everything
        int union[] = new int[count1 + count2];
        int union_count = 0;
        
        int i = 0;
        int j = 0;
        
        while (i < count1 && j < count2) {
            if (arr1[i] <= arr2[j]) {
                if (union_count == 0 || union[union_count - 1] != arr1[i]) {
                    union[union_count] = arr1[i];
                    union_count++;
                }
                i++;
            } else {
                if (union_count == 0 || union[union_count - 1] != arr2[j]) {
                    union[union_count] = arr2[j];
                    union_count++;
                }
                j++;
            }
        }
        
        while (i < count1) {
            if (union_count == 0 || union[union_count - 1] != arr1[i]) {
                union[union_count] = arr1[i];
                union_count++;
            }
            i++;
        }
        
        while (j < count2) {
            if (union_count == 0 || union[union_count - 1] != arr2[j]) {
                union[union_count] = arr2[j];
                union_count++;
            }
            j++;
        }
        
        for (int k = 0; k < union_count; k++) {
            System.out.print(union[k] + " ");
        }
        System.out.println();
    }
}
