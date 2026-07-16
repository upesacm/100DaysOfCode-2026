import java.util.Scanner;
import java.util.Stack;
class Question2{
    
    public static void main(String[]args){
        Scanner sc =new Scanner(System.in);
        Stack<Integer> st1=new Stack<>();
        Stack<Integer> st2=new Stack<>();
        System.out.println("Enter number of elements:");
        int n=sc.nextInt();
        System.out.println("Enter the elements:");

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            st1.push(num);
        }

        System.out.println(st1);
        while(st1.size()!=0){
            st2.push(st1.peek());
            st1.pop();



        }
        System.out.println(st2);
        System.out.println("Enter element to push:");
        int x=sc.nextInt();
        st1.push(x);
        while(st2.size()!=0){
            st1.push(st2.peek());
            st2.pop();

        }
        System.out.println(st1);




    
    
    
    
    }
}
