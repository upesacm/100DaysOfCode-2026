#include <bits/stdc++.h>
using namespace std;

int main() {

    int n;
    cin >> n;

    deque<int> dq;

    for(int i = n; i >= 1; i--) {

        if(!dq.empty()) {
            int x = dq.back();
            dq.pop_back();
            dq.push_front(x);
        }

        dq.push_front(i);
    }

    while(!dq.empty()) {
        cout << dq.front() << " ";
        dq.pop_front();
    }

    return 0;
}
