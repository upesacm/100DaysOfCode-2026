import java.util.Scanner;

public class w1{
    public static void main(String[] args){

        Scanner s = new Scanner(System.in);

        System.out.println("Enter the string: ");
        String st = s.nextLine();

        st = st.replace(" ", "");

        System.out.println("The modified string is: " + st);

        s.close();
        
    }
}
