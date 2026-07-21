#include <iostream>
#include <queue>
using namespace std;

int main() {
    int n, k;
    cin >> n >> k;

    queue<int> q;

    for (int i = 1; i <= n; i++) {
        q.push(i);
    }

    int minute = 0;

    while (!q.empty()) {
        minute++;

        int served = q.front();
        q.pop();

        if (served == k) {
            cout << minute;
            return 0;
        }

        if (!q.empty() && q.front() % 2 == 1) {
            int x = q.front();
            q.pop();
            q.push(x);
        }
    }

    return 0;
}