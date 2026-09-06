#define MOD 1000000007
long long power(long long a, long long b)
{
    long long result = 1;
    while (b > 0)
    {
        if (b % 2 == 1)
            result = (result * a) % MOD;
        a = (a * a) % MOD;
        b /= 2;
    }
    return result;
}
int waysToBuildRooms(int* prevRoom, int prevRoomSize)
{
    int n = prevRoomSize;
    int head[n];
    int next[n];
    for (int i = 0; i < n; i++)
        head[i] = -1;
    for (int i = 1; i < n; i++)
    {
        next[i] = head[prevRoom[i]];
        head[prevRoom[i]] = i;
    }
    int order[n];
    int stack[n];
    int top = 0;
    int count = 0;
    stack[top++] = 0;
    while (top > 0)
    {
        int node = stack[--top];
        order[count++] = node;
        for (int child = head[node]; child != -1; child = next[child])
        {
            stack[top++] = child;
        }
    }
    int subtree[n];
    for (int i = 0; i < n; i++)
        subtree[i] = 1;
    for (int i = n - 1; i > 0; i--)
    {
        int node = order[i];
        int parent = prevRoom[node];
        subtree[parent] += subtree[node];
    }
    long long numerator = 1;
    long long denominator = 1;
    for (int i = 1; i <= n; i++)
        numerator = (numerator * i) % MOD;
    for (int i = 0; i < n; i++)
        denominator = (denominator * subtree[i]) % MOD;
    long long inverseDenominator = power(denominator, MOD - 2);
    return (int)((numerator * inverseDenominator) % MOD);
}