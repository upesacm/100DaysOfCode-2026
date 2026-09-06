class MyQueue {
private:
    stack<int> inStack;
    stack<int> outStack;

    void transfer() {
        while (!inStack.empty()) {
            outStack.push(inStack.top());
            inStack.pop();
        }
    }

public:
    MyQueue() {
    }

    void push(int x) {
        inStack.push(x);
    }

    int pop() {
        if (outStack.empty())
            transfer();

        int val = outStack.top();
        outStack.pop();
        return val;
    }

    int peek() {
        if (outStack.empty())
            transfer();

        return outStack.top();
    }

    bool empty() {
        return inStack.empty() && outStack.empty();
    }
};