import java.util.*;
class convert
{

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s;
        System.out.println("Enter a string");
        s=sc.nextLine();
        int size=s.length();
        for(int i=0 ; i <size ; i++)
        {
            char ch=Character.toLowerCase(s.charAt(i));
            if(ch != 'a' && ch != 'e' && ch != 'i' && ch !='o' && ch!='u')
            {
                    System.out.print("."+ch);
            }
        }
    }
}