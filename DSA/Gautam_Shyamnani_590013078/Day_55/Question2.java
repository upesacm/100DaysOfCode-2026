import java.util.*;

class Question2 {
    public long maxPleasure(int[] length, int[] beauty, int k) {
        int n = length.length;

        int[][] songs = new int[n][2];
        for (int i = 0; i < n; i++) {
            songs[i][0] = beauty[i];
            songs[i][1] = length[i];
        }

        Arrays.sort(songs, (a, b) -> b[0] - a[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sumLengths = 0;
        long maxAns = 0;

        for (int[] song : songs) {
            int b = song[0];
            int l = song[1];

            minHeap.add(l);
            sumLengths += l;

            if (minHeap.size() > k) {
                sumLengths -= minHeap.poll();
            }

            maxAns = Math.max(maxAns, sumLengths * b);
        }

        return maxAns;
    }

    public static void main(String[] args) {
        Main obj = new Main();
        int[] length = {4, 15, 3, 6};
        int[] beauty = {7, 1, 6, 8};
        int k = 3;

        System.out.println(obj.maxPleasure(length, beauty, k)); 
    }
}