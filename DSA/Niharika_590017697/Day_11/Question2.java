import java.util.Scanner;
class Question2 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String s = sc.nextLine();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) 
        {
            char ch = Character.toLowerCase(s.charAt(i));
            if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') 
            {
                result.append('.').append(ch);
            }
        }

        System.out.println(result);
        sc.close();
    }
}
