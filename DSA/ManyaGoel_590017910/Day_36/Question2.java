import java.util.*;

public class Question2{
public static int serveTime(int n , int k){
    Queue <Integer> queue = new ArrayDeque<>();
    for( int i=1 ; i<=n ; i++){
        queue.offer(i);
    }
    int even = n/2;
    int minutes=1;
    int first=queue.poll();

    if(first==k) return minutes;
    
    if(first % 2 == 0) even--;
    
    while(!queue.isEmpty()){
        int person = queue.poll();
        if(person % 2 != 0 && even > 0){
            queue.offer(person);
        }else{
            minutes++;

            if(person==k) return minutes;
            if( person % 2 == 0) even--;          
        }
    }
    return -1;
}
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the number of people: ");
    int n = sc.nextInt();

    System.out.println("Enter the person number: ");
    int k = sc.nextInt();

    System.out.println("Person " + k + " gets the ticket at minute: " + serveTime(n,k));
    sc.close();
}
}