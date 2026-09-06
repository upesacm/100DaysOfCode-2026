#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin >> n;

    int answer = 0;

    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        answer ^= x;
    }

    cout << answer << endl;

    return 0;
}