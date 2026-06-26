import java.util.HashMap;

// Question: Determine whether two arrays contain the same elements (order may differ, frequency must match).
// Time Complexity: O(N)
// Space Complexity: O(N)

class Question2 {
    public static void main(String args[]) {
        int[] arr1 = {1, 2, 5, 4, 0};
        int[] arr2 = {2, 4, 5, 0, 1};
        
        int count1 = arr1.length;
        int count2 = arr2.length;
        
        if (count1 != count2) {
            System.out.println("false");
            return;
        }
        
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        
        for (int i = 0; i < count1; i++) {
            frequencyMap.put(arr1[i], frequencyMap.getOrDefault(arr1[i], 0) + 1);
        }
        
        for (int i = 0; i < count2; i++) {
            if (!frequencyMap.containsKey(arr2[i])) {
                System.out.println("false");
                return;
            }
            
            int currentCount = frequencyMap.get(arr2[i]);
            if (currentCount == 0) {
                System.out.println("false");
                return;
            }
            frequencyMap.put(arr2[i], currentCount - 1);
        }
        
        System.out.println("true");
    }
}
