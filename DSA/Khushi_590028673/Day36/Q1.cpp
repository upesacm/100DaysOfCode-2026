#include <iostream>
#include <queue>
using namespace std;

class MyStack {
private:
    queue<int> q1, q2;

public:
    void push(int x) {
        q2.push(x);

        while (!q1.empty()) {
            q2.push(q1.front());
            q1.pop();
        }

        swap(q1, q2);
    }

    int pop() {
        if (q1.empty()) {
            return -1;
        }

        int x = q1.front();
        q1.pop();
        return x;
    }

    int top() {
        if (q1.empty()) {
            return -1;
        }

        return q1.front();
    }

    bool empty() {
        return q1.empty();
    }
};

int main() {
    MyStack st;

    st.push(10);
    st.push(20);
    st.push(30);

    cout << "Top element: " << st.top() << endl;

    cout << "Popped: " << st.pop() << endl;
    cout << "Top element after pop: " << st.top() << endl;

    st.push(40);

    cout << "Popped: " << st.pop() << endl;
    cout << "Popped: " << st.pop() << endl;
    cout << "Popped: " << st.pop() << endl;

    if (st.empty())
        cout << "Stack is empty." << endl;
    else
        cout << "Stack is not empty." << endl;

    return 0;
}