import java.util.Scanner;
public class Question2 {
    static class TrieNode {
        TrieNode[] child;
        public TrieNode() {
            child = new TrieNode[2];
        }
    }

    private static TrieNode root;
    private static void insert(int num) {
        TrieNode curr = root;
        for (int i = 30; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (curr.child[bit] == null) {
                curr.child[bit] = new TrieNode();
            }
            curr = curr.child[bit];
        }
    }

    private static int getMaxXor(int num) {
        TrieNode curr = root;
        int maxXor = 0;
        
        for (int i = 30; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int flippedBit = 1 - bit; 
            
            if (curr.child[flippedBit] != null) {
                maxXor |= (1 << i);
                curr = curr.child[flippedBit];
            } 
            else {
                curr = curr.child[bit];
            }
        }
        
        return maxXor;
    }

    public static int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        
        root = new TrieNode();
        int maxGlobalXor = 0;
        
        insert(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            maxGlobalXor = Math.max(maxGlobalXor, getMaxXor(nums[i]));
            insert(nums[i]);
        }
        
        return maxGlobalXor;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();
            
        int[] arr = new int[n];
        System.out.println("Enter the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = findMaximumXOR(arr);
        System.out.println("Maximum XOR value: " + result);
        sc.close();
    }
}