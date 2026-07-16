import java.util.*;
class input
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> temp = new Stack<>();

        System.out.print("Enter number of elements in stack: ");
        int n=sc.nextInt();

        System.out.println("Enter stack elements:");

        for(int i=0; i<n;i++)
        {
            stack.push(sc.nextInt());
        }
        System.out.print("Enter element to insert at bottom:");
        int x=sc.nextInt();

        while(!stack.isEmpty())
        {
            temp.push(stack.pop());
        }
        stack.push(x);

        while(!temp.isEmpty())
        {
            stack.push(temp.pop());
        }
        System.out.println("Updated stack:" + stack);
    }
}