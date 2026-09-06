import java.util.Scanner;

public class CountSetBits {

    public static void main(String[] args) {

        Scanner sc = new Scanner( System.in );

        System.out.print( "Enter n: " );
        
        int n = sc.nextInt();

        int count = 0;

        // Check each bit position
        for (int bit = 0; bit < 32; bit++) {

            // Check if the current bit is 1
            if ((n & (1 << bit)) != 0) {
                count++;
            }
        }

        System.out.println( "Number of set bits: " + count );
        sc.close();
        
    }
}