#include <iostream>
#include <queue>
using namespace std;

class Solution {
public:
    queue<int> q1;
    queue<int> q2;

    void push(int ele) {
        q2.push(ele);

        while (!q1.empty()) {
            q2.push(q1.front());
            q1.pop();
        }

        swap(q1, q2);
    }

    int pop() {
        int x = q1.front();
        q1.pop();
        return x;
    }

    int top() {
        return q1.front();
    }

    bool isEmpty() {
        return q1.empty();
    }
};

int main() {
    Solution s;

    s.push(10);
    s.push(20);
    s.push(30);

    cout << s.top() << endl;   // 30
    cout << s.pop() << endl;   // 30
    cout << s.top() << endl;   // 20
}