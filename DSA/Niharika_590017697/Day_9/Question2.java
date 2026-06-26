
import java.util.Scanner;

class Question2 
{
    public static String remove(String s) 
    {
        StringBuilder ans= new StringBuilder();
        for (int i = 0; i < s.length(); i++) 
        {
            if (s.charAt(i) != ' ') 
            {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String s = sc.nextLine();
        System.out.println(remove(s));
        sc.close();
    }
}