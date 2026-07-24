class Question1_Leetcode {
    Deque<Integer> first;
    Deque<Integer> second;

    public FrontMiddleBackQueue() {
        first = new ArrayDeque<>();
        second = new ArrayDeque<>();
    }
    public void pushFront(int val) {
        first.addFirst(val);

        if (first.size() > second.size() + 1) second.addFirst(first.removeLast());
        
    }
    public void pushMiddle(int val) {
        if (first.size() > second.size()) second.addFirst(first.removeLast());
        
        first.addLast(val);
    }
    public void pushBack(int val) {
        second.addLast(val);
        if (first.size() < second.size()) first.addLast(second.removeFirst());
        
    }

    public int popFront() {
        if (first.isEmpty() && second.isEmpty()) return -1;
        int removed;
        if (!first.isEmpty()) {
            removed = first.removeFirst();
        } else {
            removed = second.removeFirst();
        }
        if (first.size() < second.size()) first.addLast(second.removeFirst());
        
        return removed;
    }

    public int popMiddle() {
        if (first.isEmpty() && second.isEmpty()) {
            return -1;
        }
        int removed = first.removeLast();
        if (first.size() < second.size()) first.addLast(second.removeFirst());
        
        return removed;
    }

    public int popBack() {
        if (first.isEmpty() && second.isEmpty()) return -1;
        int removed;
        if (!second.isEmpty()) {
            removed = second.removeLast();
        } else {
            removed = first.removeLast();
        }
        if (first.size() > second.size() + 1)  second.addFirst(first.removeLast());
        
        return removed;
    }
}