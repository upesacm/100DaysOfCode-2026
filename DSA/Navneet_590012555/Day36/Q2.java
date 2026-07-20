int ticketCounter(int n, int k) {
    Queue<Integer> q = new LinkedList<>();

    for (int i = 1; i <= n; i++)
        q.offer(i);

    int time = 0;

    while (!q.isEmpty()) {
        int x = q.poll();
        time++;

        if (x == k)
            return time;

        if (!q.isEmpty() && q.peek() % 2 == 1)
            q.offer(q.poll());
    }

    return -1;
}