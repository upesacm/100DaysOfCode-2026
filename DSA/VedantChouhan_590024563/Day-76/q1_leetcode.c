#include <stdio.h>
#include <stdlib.h>

#define MOD 1000000007LL

long long power(long long a, long long b) {
    long long result = 1;

    while (b > 0) {
        if (b & 1)
            result = result * a % MOD;

        a = a * a % MOD;
        b >>= 1;
    }

    return result;
}

long long fact[100005];
long long invFact[100005];

long long combination(int n, int r) {
    return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
}

long long waysToBuildRooms(int prevRoom[], int n) {

    fact[0] = 1;

    for (int i = 1; i <= n; i++)
        fact[i] = fact[i - 1] * i % MOD;

    invFact[n] = power(fact[n], MOD - 2);

    for (int i = n - 1; i >= 0; i--)
        invFact[i] = invFact[i + 1] * (i + 1) % MOD;

    // Build children lists
    int **children = malloc(n * sizeof(int *));
    int *childCount = calloc(n, sizeof(int));

    for (int i = 0; i < n; i++)
        children[i] = malloc(n * sizeof(int));

    for (int i = 1; i < n; i++) {
        int parent = prevRoom[i];
        children[parent][childCount[parent]++] = i;
    }

    long long *ways = calloc(n, sizeof(long long));
    int *subtreeSize = calloc(n, sizeof(int));

    for (int i = 0; i < n; i++) {
        ways[i] = 1;
        subtreeSize[i] = 1;
    }

    // Postorder traversal using stack
    int *stack = malloc(n * sizeof(int));
    int *order = malloc(n * sizeof(int));

    int top = 0;
    int count = 0;

    stack[top++] = 0;

    while (top > 0) {
        int node = stack[--top];

        order[count++] = node;

        for (int i = 0; i < childCount[node]; i++) {
            stack[top++] = children[node][i];
        }
    }

    // Process children before parents
    for (int i = n - 1; i >= 0; i--) {

        int node = order[i];
        int total = 0;

        for (int j = 0; j < childCount[node]; j++) {

            int child = children[node][j];
            int s = subtreeSize[child];

            ways[node] =
                ways[node] * ways[child] % MOD;

            ways[node] =
                ways[node] * combination(total + s, s) % MOD;

            total += s;
        }

        subtreeSize[node] = total + 1;
    }

    long long answer = ways[0];

    // Free memory
    for (int i = 0; i < n; i++)
        free(children[i]);

    free(children);
    free(childCount);
    free(ways);
    free(subtreeSize);
    free(stack);
    free(order);

    return answer;
}

int main() {

    int n;

    printf("Enter number of rooms: ");
    scanf("%d", &n);

    int prevRoom[n];

    printf("Enter prevRoom array:\n");

    for (int i = 0; i < n; i++)
        scanf("%d", &prevRoom[i]);

    printf("Number of ways: %lld\n",
           waysToBuildRooms(prevRoom, n));

    return 0;
}