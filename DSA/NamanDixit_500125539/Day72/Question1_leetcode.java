
class Question1_leetcode {

    // Function to find the center of a star graph
    public int findCenter(int[][] edges) {

        // In a star graph, the center appears
        // in both of the first two edges.
        //
        // So we only need to compare them.
        // First edge: [a, b]
        int a = edges[0][0];
        int b = edges[0][1];

        // Second edge: [c, d]
        int c = edges[1][0];
        int d = edges[1][1];

        // If a is present in both edges,
        // a is the center.
        if (a == c || a == d) {
            return a;
        }

        // Otherwise, b is the center.
        return b;
    }
}
