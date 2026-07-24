import java.util.ArrayDeque;
import java.util.Deque;

class FrontMiddleBackQueue {
    private Deque<Integer> left;
    private Deque<Integer> right;

    public FrontMiddleBackQueue() {
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
    }

    private void rebalance() {
        // left can't have more than right
        if (left.size() > right.size()) {
            right.addFirst(left.removeLast());
        }
        // right can't have more than left + 1
        else if (right.size() > left.size() + 1) {
            left.addLast(right.removeFirst());
        }
    }

    public void pushFront(int val) {
        left.addFirst(val);
        rebalance();
    }

    public void pushMiddle(int val) {
        if (left.size() < right.size()) {
            left.addLast(val);
        } else {
            right.addFirst(val);
        }
        rebalance();
    }

    public void pushBack(int val) {
        right.addLast(val);
        rebalance();
    }

    public int popFront() {
        if (left.isEmpty() && right.isEmpty()) return -1;

        int val;
        if (!left.isEmpty()) {
            val = left.removeFirst();
        } else {
            val = right.removeFirst(); // left empty means right has at most 1 element
        }
        rebalance();
        return val;
    }

    public int popMiddle() {
        if (left.isEmpty() && right.isEmpty()) return -1;

        int val;
        if (left.size() == right.size()) {
            val = left.removeLast();
        } else {
            val = right.removeFirst();
        }
        rebalance();
        return val;
    }

    public int popBack() {
        if (left.isEmpty() && right.isEmpty()) return -1;

        int val = right.removeLast(); // right always has >= elements, so if anything exists, right is non-empty
        rebalance();
        return val;
    }
}
