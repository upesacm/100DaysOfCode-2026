import java.util.*;
import java.io.*;

public class CrabChaos {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int C = (int) st.nval;
        StringBuilder sb = new StringBuilder();

        while (C-- > 0) {
            st.nextToken(); int n = (int) st.nval;
            st.nextToken(); int t = (int) st.nval;
            st.nextToken(); int m = (int) st.nval;

            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

            for (int i = 0; i < m; i++) {
                st.nextToken(); int u = (int) st.nval;
                st.nextToken(); int v = (int) st.nval;
                adj.get(u).add(v);
                adj.get(v).add(u);
            }

            // Process vertices highest-degree first — a hub is more useful as a head
            Integer[] order = new Integer[n];
            for (int i = 1; i <= n; i++) order[i - 1] = i;
            Arrays.sort(order, (a, b) -> adj.get(b).size() - adj.get(a).size());

            boolean[] used = new boolean[n + 1];
            int covered = 0;

            for (int u : order) {
                if (used[u]) continue;
                List<Integer> feet = new ArrayList<>();
                for (int v : adj.get(u)) {
                    if (feet.size() == t) break;
                    if (!used[v]) feet.add(v);
                }
                if (!feet.isEmpty()) {           // need >=1 foot to form a crab
                    used[u] = true;
                    covered++;
                    for (int v : feet) { used[v] = true; covered++; }
                }
            }
            sb.append(covered).append("\n");
        }
        System.out.print(sb);
    }
}
