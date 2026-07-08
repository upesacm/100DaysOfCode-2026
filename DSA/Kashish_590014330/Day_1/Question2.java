class Main {
    public static void main(String[] args) {

        int nums[] = {-4, -1, 0, 3, 10};
        int copy[] = new int[nums.length];

        // Square each element
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i] * nums[i];
        }

        // Bubble Sort
        for (int i = 0; i < copy.length - 1; i++) {
            for (int j = 0; j < copy.length - 1 - i; j++) {
                if (copy[j] > copy[j + 1]) {
                    int temp = copy[j];
                    copy[j] = copy[j + 1];
                    copy[j + 1] = temp;
                }
            }
        }

        // Print the sorted squares
        for (int i = 0; i < copy.length; i++) {
            System.out.print(copy[i] + " ");
        }
    }
}