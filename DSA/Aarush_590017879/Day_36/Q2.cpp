#include <iostream>
#include <queue>
using namespace std;

int servedMinute(int n, int k) {
    queue<int> q;

    for (int i = 1; i <= n; i++)
        q.push(i);

    int minute = 0;

    while (!q.empty()) {
        minute++;

        int served = q.front();
        q.pop();

        if (served == k)
            return minute;

        if (!q.empty() && (q.front() % 2 == 1)) {
            int person = q.front();
            q.pop();
            q.push(person);
        }
    }

    return -1;
}

int main() {
    int n = 4, k = 3;

    cout << servedMinute(n, k);

    return 0;
}