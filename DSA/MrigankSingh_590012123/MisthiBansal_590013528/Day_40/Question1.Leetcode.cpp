// leetcode-1670
class FrontMiddleBackQueue {
public:
    deque<int> left;
    deque<int> right;

    FrontMiddleBackQueue() {

    }

    void balance() {

        if(left.size() > right.size() + 1) {
            right.push_front(left.back());
            left.pop_back();
        }

        if(left.size() < right.size()) {
            left.push_back(right.front());
            right.pop_front();
        }
    }

    void pushFront(int val) {
        left.push_front(val);
        balance();
    }

    void pushMiddle(int val) {

        if(left.size() > right.size()) {
            right.push_front(left.back());
            left.pop_back();
        }

        left.push_back(val);
    }

    void pushBack(int val) {
        right.push_back(val);
        balance();
    }

    int popFront() {

        if(left.empty() && right.empty())
            return -1;

        int x = left.front();
        left.pop_front();

        balance();

        return x;
    }

    int popMiddle() {

        if(left.empty() && right.empty())
            return -1;

        int x = left.back();
        left.pop_back();

        balance();

        return x;
    }

    int popBack() {

        if(left.empty() && right.empty())
            return -1;

        int x;

        if(!right.empty()) {
            x = right.back();
            right.pop_back();
        }
        else {
            x = left.back();
            left.pop_back();
        }

        balance();

        return x;
    }
};