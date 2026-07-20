#include <bits/stdc++.h>
using namespace std;

int ticketCounterQueue(int n, int k) {
    queue<int> q;

    for (int i = 1; i <= n; i++)
        q.push(i);

    int minute = 0;

    while (!q.empty()) {
        int person = q.front();
        q.pop();
        minute++;

        if (person == k)
            return minute;

        if (!q.empty() && q.front() % 2 == 1) {
            int x = q.front();
            q.pop();
            q.push(x);
        }
    }

    return -1;
}