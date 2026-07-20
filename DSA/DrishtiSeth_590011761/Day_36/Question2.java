import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Question2 {

    public static int ticketTime(int n, int k) {

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1;i<=n;i++){
            queue.add(i);
        }

        int minute=0;

        while(!queue.isEmpty()){

            int person=queue.remove();
            minute++;

            if(person==k){
                return minute;
            }

            if(!queue.isEmpty()){

                int front=queue.peek();

                if(front%2!=0){
                    queue.remove();
                    queue.add(front);
                }
            }
        }

        return -1;
    }

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int k=sc.nextInt();

        System.out.println(ticketTime(n,k));
    }
}
