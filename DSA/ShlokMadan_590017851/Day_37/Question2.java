import java.util.LinkedList;
import java.util.Queue;
public class Question2 
{
    static class Document 
    {
        int priority;
        int index;
        Document(int priority,int index) 
        {
            this.priority=priority;
            this.index=index;
        }
    }
    public static int printTime(int[] priorities,int location) 
    {
        Queue<Document> q=new LinkedList<>();
        for(int i=0;i<priorities.length;i++) 
            {
            q.offer(new Document(priorities[i],i));
        }
        int time=0;
        while(!q.isEmpty()) 
            {
            Document cur=q.poll();
            boolean higher=false;
            for(Document d:q) 
                {
                if(d.priority>cur.priority) 
                    {
                    higher=true;
                    break;
                }
            }
            if(higher) 
                {
                q.offer(cur);
            }
            else 
                {
                time++;
                if(cur.index==location) 
                    {
                    return time;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] priorities={2,1,3,2};
        int location=2;

        System.out.println(printTime(priorities,location));
    }
}