import java.util.Arrays;

class Question2 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4}; // Sample test case
        
        int[] result = new int[arr.length];
        Arrays.fill(result, -1);
        
        int[] stack = new int[arr.length];
        int top = -1;
        
        for (int i = 0; i < arr.length; i++) {
            while (top >= 0 && arr[stack[top]] < arr[i]) {
                result[stack[top]] = arr[i];
                top--;
            }
            
            top++;
            stack[top] = i;
        }
        
        System.out.println(Arrays.toString(result));
    }
}
