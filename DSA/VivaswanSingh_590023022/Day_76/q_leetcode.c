#define MOD 1000000007LL

long long power(long long a, long long b)
{
    long long result = 1;

    while (b > 0)
    {
        if (b & 1)
            result = result * a % MOD;

        a = a * a % MOD;
        b >>= 1;
    }

    return result;
}

long long combination(int n, int k, long long *fact, long long *invFact)
{
    if (k < 0 || k > n)
        return 0;

    return fact[n] * invFact[k] % MOD * invFact[n - k] % MOD;
}

int waysToBuildRooms(int* prevRoom, int prevRoomSize)
{
    int n = prevRoomSize;

    int *firstChild = malloc(n * sizeof(int));
    int *nextSibling = malloc(n * sizeof(int));

    for (int i = 0; i < n; i++)
    {
        firstChild[i] = -1;
        nextSibling[i] = -1;
    }

    for (int i = 1; i < n; i++)
    {
        nextSibling[i] = firstChild[prevRoom[i]];
        firstChild[prevRoom[i]] = i;
    }

    long long *fact = malloc(n * sizeof(long long));
    long long *invFact = malloc(n * sizeof(long long));

    fact[0] = 1;

    for (int i = 1; i < n; i++)
        fact[i] = fact[i - 1] * i % MOD;

    invFact[n - 1] = power(fact[n - 1], MOD - 2);

    for (int i = n - 2; i >= 0; i--)
        invFact[i] = invFact[i + 1] * (i + 1) % MOD;

    int *order = malloc(n * sizeof(int));
    int *stack = malloc(n * sizeof(int));

    int top = 0;
    int orderSize = 0;

    stack[top++] = 0;

    while (top > 0)
    {
        int node = stack[--top];
        order[orderSize++] = node;

        for (int child = firstChild[node];
             child != -1;
             child = nextSibling[child])
        {
            stack[top++] = child;
        }
    }

    int *subtreeSize = calloc(n, sizeof(int));
    long long *ways = calloc(n, sizeof(long long));

    for (int i = n - 1; i >= 0; i--)
    {
        int node = order[i];

        subtreeSize[node] = 1;
        ways[node] = 1;

        int total = 0;

        for (int child = firstChild[node];
             child != -1;
             child = nextSibling[child])
        {
            int childSize = subtreeSize[child];

            ways[node] = ways[node] * ways[child] % MOD;

            ways[node] = ways[node] *
                combination(total + childSize,
                             childSize,
                             fact,
                             invFact) % MOD;

            total += childSize;
            subtreeSize[node] += childSize;
        }
    }

    int answer = (int)ways[0];

    free(firstChild);
    free(nextSibling);
    free(fact);
    free(invFact);
    free(order);
    free(stack);
    free(subtreeSize);
    free(ways);

    return answer;
}