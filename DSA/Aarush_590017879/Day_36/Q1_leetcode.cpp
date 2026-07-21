#include <iostream>
#include <queue>
using namespace std;

class MyStack {
private:
    queue<int> q1, q2;

public:
    MyStack() {}

    void push(int x) {
        q2.push(x);

        while (!q1.empty()) {
            q2.push(q1.front());
            q1.pop();
        }

        swap(q1, q2);
    }

    int pop() {
        int val = q1.front();
        q1.pop();
        return val;
    }

    int top() {
        return q1.front();
    }

    bool empty() {
        return q1.empty();
    }
};

int main() {
    MyStack st;

    st.push(1);
    st.push(2);
    st.push(3);

    cout << "Top: " << st.top() << endl;

    cout << "Popped: " << st.pop() << endl;

    cout << "Top after pop: " << st.top() << endl;

    if (st.empty())
        cout << "Stack is Empty";
    else
        cout << "Stack is Not Empty";

    return 0;
}