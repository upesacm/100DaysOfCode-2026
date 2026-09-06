import java.util.*;
public class Question2 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashSet<Integer>[] roads = new HashSet[n + 1];
        for (int i = 1; i <= n; i++) 
            {
            roads[i] = new HashSet<>();
        }
        for (int i = 0; i < m; i++) 
            {
            int u = sc.nextInt();
            int v = sc.nextInt();
            roads[u].add(v);
            roads[v].add(u);
        }
        int start = sc.nextInt();
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);
        Queue<Integer> queue = new LinkedList<>();
        TreeSet<Integer> unvisited = new TreeSet<>();
        for (int i = 1; i <= n; i++) 
            {
            if (i != start) 
                {
                unvisited.add(i);
            }
        }
        distance[start] = 0;
        queue.add(start);
        while (!queue.isEmpty()) 
            {
            int current = queue.poll();
            Iterator<Integer> iterator = unvisited.iterator();
            while (iterator.hasNext()) 
                {
                int next = iterator.next();
                if (!roads[current].contains(next)) 
                    {
                    distance[next] = distance[current] + 1;
                    queue.add(next);
                    iterator.remove();
                }
            }
        }
        for (int i = 1; i <= n; i++) 
            {
            if (i != start) 
                {
                System.out.print(distance[i] + " ");
            }
        }
    }
}