import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.err.println("Enter the size of array:");
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            

            if (n > 0) {
                System.out.println("Enter the elements of the array:");
                int maxVal = scanner.nextInt();
                
                for (int i = 1; i < n; i++) {
                    int currentNum = scanner.nextInt();
                    if (currentNum > maxVal) {
                        maxVal = currentNum;
                    }
                }
                
                System.out.println("Max element is:");
                System.out.println(maxVal);
            }
        }
        
        scanner.close();
    }
}