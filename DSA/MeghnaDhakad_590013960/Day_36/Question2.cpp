#include <iostream>
#include <queue>
using namespace std;

int servedMinute(int n, int k) {
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

        if (person % 2 == 1)
            q.push(person);
    }

    return -1;
}

int main() {
    int n = 4;
    int k = 3;

    cout << servedMinute(n, k);

    return 0;
}