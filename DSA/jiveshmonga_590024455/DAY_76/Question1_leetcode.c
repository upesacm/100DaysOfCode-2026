#include <stdlib.h>

#define MOD 1000000007

long long fact[100005];
long long invFact[100005];

long long power(long long a, long long b) {
    long long result = 1;

    while (b > 0) {
        if (b % 2)
            result = result * a % MOD;

        a = a * a % MOD;
        b /= 2;
    }

    return result;
}

long long comb(int n, int r) {
    return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
}

int child[100005][20];
int childCount[100005];
long long ways[100005];
int size[100005];

void dfs(int node) {
    size[node] = 1;
    ways[node] = 1;

    int total = 0;

    for (int i = 0; i < childCount[node]; i++) {
        int v = child[node][i];

        dfs(v);

        ways[node] =
            ways[node] * ways[v] % MOD;

        ways[node] =
            ways[node] * comb(total + size[v], size[v]) % MOD;

        total += size[v];
        size[node] += size[v];
    }
}

int waysToBuildRooms(int* prevRoom, int prevRoomSize) {
    int n = prevRoomSize;

    for (int i = 0; i < n; i++)
        childCount[i] = 0;

    for (int i = 1; i < n; i++) {
        int p = prevRoom[i];
        child[p][childCount[p]++] = i;
    }

    fact[0] = 1;

    for (int i = 1; i < n; i++)
        fact[i] = fact[i - 1] * i % MOD;

    invFact[n - 1] = power(fact[n - 1], MOD - 2);

    for (int i = n - 2; i >= 0; i--)
        invFact[i] = invFact[i + 1] * (i + 1) % MOD;

    dfs(0);

    return ways[0];
}