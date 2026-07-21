import java.util.LinkedList;
import java.util.Queue;
public class Question1 
{
    Queue<Integer> q;
    public Question1() 
    {
        q=new LinkedList<>();
    }
    public int ping(int t) 
    {
        q.offer(t);
        while(q.peek()<t-3000) 
            {
            q.poll();
        }
        return q.size();
    }
    public static void main(String[] args) 
    {
        Question1 rc=new Question1();
        System.out.println(rc.ping(1));
        System.out.println(rc.ping(100));
        System.out.println(rc.ping(3001));
        System.out.println(rc.ping(3002));
    }
}