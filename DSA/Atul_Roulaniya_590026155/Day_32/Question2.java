import java.util.*;
class copy
{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);

        Stack<Integer> st1 = new  Stack<>();
        Stack<Integer> st2 = new  Stack<>();
        Stack<Integer> temp = new Stack<>();   

        System.out.print("Enter the number of elements:");
        int n=sc.nextInt();

        System.out.println("Enter the elements");

        for(int i=0;i<n;i++)
        {
            st1.push(sc.nextInt());
        }

        while(!st1.isEmpty())
        {
            temp.push(st1.pop());
        } 

        while(!temp.isEmpty())
        {
            int x=temp.pop();
            st1.push(x);
            st2.push(x);
        }

        while(!st2.isEmpty())
        {
            temp.push(st2.pop());
        }

        while(!temp.isEmpty())
        {
            st2.push(temp.pop());
        }

        System.out.println("Original stack:" + st1);
        System.out.println("Copied stack:" + st2);

    }
}