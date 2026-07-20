#include <iostream>
#include <stack>
using namespace std;

class Solution {
public:
    stack<int> input;
    stack<int> output;
    int frontValue = -1;

    void push(int ele) {
        if (input.empty()) {
            frontValue = ele;
        }
        input.push(ele);
    }

    int pop() {
        if (output.empty()) {
            while (!input.empty()) {
                output.push(input.top());
                input.pop();
            }
        }
        if (output.empty()) {
            return -1;
        }
        int val = output.top();
        output.pop();
        return val;
    }

    int peek() {
        if (!output.empty()) {
            return output.top();
        }
        return frontValue;
    }

    bool empty() {
        return input.empty() && output.empty();
    }
};

int main() {
    Solution o;
    o.push(7);
    o.push(8);
    cout << "Front element: " << o.peek() << endl;
    cout << "Popped: " << o.pop() << endl;
    cout << "Is empty? " << (o.empty() ? "true" : "false") << endl;
    return 0;
}