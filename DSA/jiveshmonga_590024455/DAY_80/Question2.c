bool isPowerOfTwo(int n) {
    if (n == 0)
        return true;

    return (n & (n - 1)) == 0;
}