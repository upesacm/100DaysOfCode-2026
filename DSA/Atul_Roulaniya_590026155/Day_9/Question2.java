import java.util.*;
class removespace
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        {
            String str;
            System.out.println("Enter string");
            str=sc.nextLine();
            int size=str.length();
            String newstr="";
                for(int i=0;i<size; i++)
                {
                    char ch=str.charAt(i);
                    if(ch != ' ')
                    {
                        newstr=newstr+ch;
                    }
                }
        System.out.println(newstr);
        }
    }
}