#include <bits/stdc++.h>
using namespace std;

int main() {
    int n, k;
    cout << "Enter n and k: ";
    cin >> n >> k;

    queue<int> q;

    // Initially fill the queue
    for (int i = 1; i <= n; i++)
        q.push(i);

    int minute = 0;

    while (!q.empty()) {

        // Serve the front person
        int served = q.front();
        q.pop();
        minute++;

        // Check if this is the target person
        if (served == k) {
            cout << "Person " << k << " gets the ticket at minute " << minute << endl;
            return 0;
        }

        // Move the next front person to the back if odd
        if (!q.empty() && q.front() % 2 != 0) {
            int x = q.front();
            q.pop();
            q.push(x);
        }
    }

    return 0;
}