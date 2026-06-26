public class Q2 {
    public static String toReverse (String temp) {
        String reversed = new StringBuilder(temp).reverse().toString();
        return reversed;


    }
    public static void main (String [] args ){
        String temp = "Computer";
        String reverse = toReverse(temp);
        System.out.println(reverse);

    }
    
}