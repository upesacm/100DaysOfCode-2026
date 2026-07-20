import java.util.*;
class main
{
    public static void main(String[] args) 
    {
        Scanner sc= new Scanner(System.in);

        int n=sc.nextInt();
        int k=sc.nextInt();

        Queue<Integer> q= new LinkedList<>();

        for(int i=1; i<=n ;i++)
        {
            q.offer(i);
        }

        int minute=0;

        while( !q.isEmpty())
        {
            int served = q.poll();
            minute++;

            if(served == k)
            {
                System.out.println(minute);
                break;
            }

            if(!q.isEmpty())
            {
                int front =q.poll();

                if(front % 2 ==1)
                {
                    q.offer(front);
                }
                else
                {
                    Queue<Integer>temp = new LinkedList<>();
                    
                    temp.offer(front);

                    while(!q.isEmpty())
                    {
                        temp.offer(q.poll());
                    }
                    q=temp;
                }
            }
        }
    }   
}