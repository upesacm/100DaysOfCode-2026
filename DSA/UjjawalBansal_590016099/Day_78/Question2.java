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
        TrieNode cur = root;
        for (int i = 30; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (cur.child[bit] == null) {
                cur.child[bit] = new TrieNode();
            }
            cur = cur.child[bit];
        }
    }

    private static int getMaxXor(int num) {
        TrieNode curr = root;
        int max = 0;
        
        for (int i = 30; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int flippedBit = 1 - bit; 
            if (curr.child[flippedBit] != null) {
                max |= (1 << i);
                curr = curr.child[flippedBit];
            } 
            else {
                curr = curr.child[bit];
            }
        }
        return max;
    }

    public static int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        root = new TrieNode();
        int globalMaxXor = 0;
        
        insert(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            globalMaxXor = Math.max(globalMaxXor, getMaxXor(nums[i]));
            insert(nums[i]);
        }
        return globalMaxXor;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();
            
        int[] arr = new int[n];
        System.out.println("Enter the array numbers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = findMaximumXOR(arr);
        System.out.println("Maximum XOR value possible: " + result);
        sc.close();
    }
}
