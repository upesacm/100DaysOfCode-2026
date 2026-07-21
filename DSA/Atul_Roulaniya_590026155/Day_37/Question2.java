import java.util.*;
class main{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(Sysytem.in);

        System.out.print("Enter number of documents");
        int n=sc.nextInt();

        int[] priorities = new int[n];

        System.out.println("Enter priorities:");
        for(int i=0;i<n;i++)
        {
            priorities[i]=sc.nextInt();
        }
        System.out.print("Enter location");
        int location=sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();

        for(int i=0 ; i <n ; i++)
        {
            queue.offer(priorities[i]);
            index.offer(i);
        }

        int time=0;

        while(true)
        {
            int current=queue.peek();
            boolean higher =false;

            for(int x : queue)
            {
                if(x > current)
                {
                    higher = true;
                    break;
                }
            }
            if(higher)
            {
                queue.offer(queue.poll());
                index.offer(index.poll());
            }
            else{
                time++;

                int pos=index.poll();
                queue.poll();

                if(pos == location)
                {
                    System.out.println("Time taken =" + time);
                    break;
                }
            }
            
        }
    }
}