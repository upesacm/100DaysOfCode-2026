// Question: Given an integer array and an integer k, rotate the array to the right by k steps.
// Time Complexity: O(N)
// Space Complexity: O(N)

class Question2 {
    public static void main(String args[]) {
        int array[] = {1, 2, 3, 4};
        int count = array.length;
        int values_rotated = 3;
        
        values_rotated = values_rotated % count;
        int new_array[] = new int[count];
        
        for (int i = 0; i < count; i++) {
            new_array[(i + values_rotated) % count] = array[i];
        }
        
        for (int i = 0; i < count; i++) {
            System.out.print(new_array[i] + " ");
        }
        System.out.println();
    }
}
