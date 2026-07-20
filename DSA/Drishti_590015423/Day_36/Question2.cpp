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

        int person = q.front();
        q.pop();

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

int main() {
    cout << servedMinute(4, 3);
}
