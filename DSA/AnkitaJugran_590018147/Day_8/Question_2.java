public class Reverse_String {
    public static void main( String[] args){
        String str = "Laptop";
        System.out.println("Original String: " + str);

        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        System.out.println("Reversed String: " + sb.toString());
    }
}