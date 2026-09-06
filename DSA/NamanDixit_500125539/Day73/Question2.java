import java.util.Scanner;

public class Question2 {

    // ------------------------------------------------------------------
    // These two arrays are the heart of "Union-Find" (Disjoint Set Union)
    // parent[i]  -> tells us who the "boss/leader" of village i is
    // size[i]    -> only meaningful for a leader: how many villages are
    //               in that leader's group (cluster)
    // ------------------------------------------------------------------
    static int[] parent;
    static int[] size;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Step 1: Take input from the user
        System.out.print("Enter number of villages (N): ");
        int n = sc.nextInt();

        System.out.print("Enter number of roads (M): ");
        int m = sc.nextInt();

        // We create arrays of size (n+1) because villages are numbered
        // 1 to N (not 0 to N-1), so we just ignore index 0.
        parent = new int[n + 1];
        size = new int[n + 1];

        // Step 2: Initially, every village is its own leader (its own cluster)
        // and every cluster has size 1 (just itself).
        for (int i = 1; i <= n; i++) {
            parent[i] = i;   // every village points to itself
            size[i] = 1;     // every cluster starts with 1 village
        }

        // Step 3: Read all the M roads and connect the villages
        System.out.println("Enter " + m + " roads (two village numbers per road):");
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            union(a, b); // connect village a and village b
        }

        // Step 4: Now count how many separate clusters exist,
        // and find the size of the biggest one.
        int wells = 0;       // one well needed per separate cluster
        int largestCluster = 0;

        for (int i = 1; i <= n; i++) {
            // "i" is a leader of its own cluster only if it points to itself
            if (find(i) == i) {
                wells++; // found one more separate cluster
                if (size[i] > largestCluster) {
                    largestCluster = size[i];
                }
            }
        }

        // Step 5: Print the final answer
        System.out.println("Minimum wells needed: " + wells);
        System.out.println("Largest cluster size: " + largestCluster);

        sc.close();
    }

    // ------------------------------------------------------------------
    // find(x): Finds the "leader" (root) of the cluster that village x
    // belongs to. Uses "path compression" so future lookups are faster:
    // every village on the path gets directly connected to the leader.
    // ------------------------------------------------------------------
    static int find(int x) {
        if (parent[x] != x) {
            // Keep going up until we find the real leader,
            // and while coming back, attach x directly to that leader.
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // ------------------------------------------------------------------
    // union(a, b): Joins the clusters containing village a and village b
    // into a single cluster. Uses "union by size" — the smaller cluster
    // is attached under the bigger one, which keeps things fast.
    // ------------------------------------------------------------------
    static void union(int a, int b) {
        int leaderA = find(a); // leader of a's cluster
        int leaderB = find(b); // leader of b's cluster

        // If they already belong to the same cluster, nothing to do.
        if (leaderA == leaderB) {
            return;
        }

        // Attach the smaller cluster under the bigger one.
        if (size[leaderA] < size[leaderB]) {
            parent[leaderA] = leaderB;       // A's leader now follows B's leader
            size[leaderB] += size[leaderA];  // update B's cluster size
        } else {
            parent[leaderB] = leaderA;       // B's leader now follows A's leader
            size[leaderA] += size[leaderB];  // update A's cluster size
        }
    }
}