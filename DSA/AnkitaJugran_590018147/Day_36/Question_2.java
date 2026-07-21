package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TicketCounterQueue {

    public static void main( String[] args ){
        Scanner sc = new Scanner(System.in);

        Queue<Integer> ticketqueue = new LinkedList<>();

        int n;
        System.out.print("Enter the number of tickets to be added: ");
        n = sc.nextInt();

        int k;
        System.out.print("Enter the person number to find the minute they are served: ");
        k = sc.nextInt();

        for(int i = 1; i <= n; i++){
            ticketqueue.offer(i);
        }

        int min = 0;
        while( !ticketqueue.isEmpty() ){

            //first person will get served.
            min++;
            int served = ticketqueue.poll();

            //if person number is odd, it will be added to the back and will not be served.
        
            if( served == k ){
                    System.out.println("The person number " + k + " was served in " + min + " minutes.");
                    break;
            }
            if( ! ticketqueue.isEmpty() && ticketqueue.peek() % 2 != 0 )
                {
                    ticketqueue.offer( ticketqueue.poll() );
            }
        }
                 
    }   
}

