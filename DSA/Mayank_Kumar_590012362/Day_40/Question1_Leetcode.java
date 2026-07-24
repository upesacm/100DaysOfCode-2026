class FrontMiddleBackQueue {
    Deque<Integer> a, b;
    public FrontMiddleBackQueue() {
        a = new ArrayDeque<>();
        b = new ArrayDeque<>();
    }
    void f() {
        if (a.size() < b.size()) a.addLast(b.removeFirst());
        else if (a.size() > b.size() + 1) b.addFirst(a.removeLast());
    }
    public void pushFront(int x) {
        a.addFirst(x);
        f();
    }
    public void pushMiddle(int x) {
        if (a.size() > b.size()) b.addFirst(a.removeLast());
        a.addLast(x);
    }
    public void pushBack(int x) {
        b.addLast(x);
        f();
    }
    public int popFront() {
        if (a.isEmpty()) return -1;
        int x = a.removeFirst();
        f();
        return x;
    }
    public int popMiddle() {
        if (a.isEmpty()) return -1;
        int x = a.removeLast();
        f();
        return x;
    }
    public int popBack() {
        if (a.isEmpty()) return -1;
        int x = b.isEmpty() ? a.removeLast() : b.removeLast();
        f();
        return x;
    }
}