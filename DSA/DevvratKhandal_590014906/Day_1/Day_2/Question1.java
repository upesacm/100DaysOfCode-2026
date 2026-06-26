    //CODE for removing a certain element from an array
    import java.util.Scanner; 
    public class Question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size of array: \n");
        int n = sc.nextInt(); // size of array
        int[] nums = new int[n];

        // input array elements
        System.out.println("Elements in array: \n");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Value to remove from dataset: \'n");
        int val = sc.nextInt(); // value to remove

        int k = 0; // count of remaining elements

        for (int i = 0; i < n; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        System.out.println(k);

        System.out.print("Remaining array: [");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i]);
            if (i < k - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        sc.close();
    }
}