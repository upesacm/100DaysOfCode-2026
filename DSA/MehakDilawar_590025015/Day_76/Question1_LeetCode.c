#define MOD 1000000007LL

long long modPow(long long a, long long b) {
    long long res = 1;
    while (b) {
        if (b & 1)
            res = res * a % MOD;
        a = a * a % MOD;
        b >>= 1;
    }
    return res;
}

int waysToBuildRooms(int* prevRoom, int prevRoomSize) {
    int n = prevRoomSize;
    int* head = malloc(n * sizeof(int));
    int* next = malloc(n * sizeof(int));
    for (int i = 0; i < n; i++)
        head[i] = -1;

    for (int i = 1; i < n; i++) {
        next[i] = head[prevRoom[i]];
        head[prevRoom[i]] = i;
    }
    long long* fact = malloc((n + 1) * sizeof(long long));
    long long* invFact = malloc((n + 1) * sizeof(long long));
    fact[0] = 1;
    for (int i = 1; i <= n; i++)
        fact[i] = fact[i - 1] * i % MOD;
    invFact[n] = modPow(fact[n], MOD - 2);
    for (int i = n; i >= 1; i--)
        invFact[i - 1] = invFact[i] * i % MOD;
    int* order = malloc(n * sizeof(int));
    int* stack = malloc(n * sizeof(int));
    int top = 0;
    int orderSize = 0;
    stack[top++] = 0;
    while (top > 0) {
        int u = stack[--top];
        order[orderSize++] = u;
        for (int v = head[u]; v != -1; v = next[v])
            stack[top++] = v;
    }
    int* size = malloc(n * sizeof(int));
    long long* ways = malloc(n * sizeof(long long));
    for (int i = 0; i < n; i++) {
        size[i] = 1;
        ways[i] = 1;
    }
    for (int i = n - 1; i >= 0; i--) {
        int u = order[i];
        int total = 0;
        long long ans = 1;
        for (int v = head[u]; v != -1; v = next[v]) {
            total += size[v];
            ans = ans * ways[v] % MOD;
            ans = ans * invFact[size[v]] % MOD;
        }
        ans = ans * fact[total] % MOD;
        ways[u] = ans;
        size[u] = total + 1;
    }

    int result = (int)ways[0];
    free(head);
    free(next);
    free(fact);
    free(invFact);
    free(order);
    free(stack);
    free(size);
    free(ways);
    return result;
}