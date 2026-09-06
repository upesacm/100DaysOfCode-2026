class Solution {
public:
    static const int MOD = 1e9 + 7;

    long long power(long long a, long long b) {
        long long ans = 1;

        while (b > 0) {
            if (b & 1)
                ans = ans * a % MOD;

            a = a * a % MOD;
            b >>= 1;
        }

        return ans;
    }

    int waysToBuildRooms(vector<int>& prevRoom) {
        int n = prevRoom.size();

        vector<vector<int>> children(n);

        for (int i = 1; i < n; i++) {
            children[prevRoom[i]].push_back(i);
        }

        vector<long long> fact(n), invFact(n);

        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invFact[n - 1] = power(fact[n - 1], MOD - 2);

        for (int i = n - 1; i >= 1; i--) {
            invFact[i - 1] = invFact[i] * i % MOD;
        }

        vector<int> order;
        order.reserve(n);

        stack<int> st;
        st.push(0);

        while (!st.empty()) {
            int node = st.top();
            st.pop();

            order.push_back(node);

            for (int child : children[node]) {
                st.push(child);
            }
        }

        vector<int> subtreeSize(n, 1);
        vector<long long> ways(n, 1);

        for (int i = n - 1; i >= 0; i--) {
            int node = order[i];

            for (int child : children[node]) {

                int total =
                    subtreeSize[node] + subtreeSize[child] - 1;

                long long combinations =
                    fact[total] *
                    invFact[subtreeSize[node] - 1] % MOD *
                    invFact[subtreeSize[child]] % MOD;

                ways[node] =
                    ways[node] * ways[child] % MOD;

                ways[node] =
                    ways[node] * combinations % MOD;

                subtreeSize[node] += subtreeSize[child];
            }
        }

        return ways[0];
    }
};