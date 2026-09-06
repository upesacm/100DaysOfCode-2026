public class TurnOffRightmostBit {

    public static void main( String[] args){

        int n = 12;

        int result = n & (n - 1);
        System.out.println("The number after turning off the rightmost set bit is: " + result);
    }
    
}
