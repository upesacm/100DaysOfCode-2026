#include <iostream>
#include <queue>
using namespace std;

int ticketCounter(int n, int k) {
    queue<int> q;

    for (int i = 1; i <= n; i++)
        q.push(i);

    int minute = 0;

    while (!q.empty()) {
        int served = q.front();
        q.pop();
        minute++;

        if (served == k)
            return minute;

        if (!q.empty() && q.front() % 2 == 1) {
            int x = q.front();
            q.pop();
            q.push(x);
        }
    }

    return -1;
}

int main() {
    int n, k;
    cin >> n >> k;

    cout << ticketCounter(n, k);

    return 0;
}