int hammingDistance(int x, int y) {
    int xor = x ^ y;
    int count = 0;

    while (xor) {
        count += xor & 1;
        xor >>= 1;
    }

    return count;
}