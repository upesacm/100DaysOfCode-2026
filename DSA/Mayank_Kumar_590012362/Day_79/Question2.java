class Question2 {
    static int find(int[] a) {
    int x = 0;
    for (int n : a) x ^= n;
    return x;
}
}