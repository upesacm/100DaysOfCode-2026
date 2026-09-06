int hammingDistance(int x, int y) {
    int value = x ^ y;
    int count = 0;
    while (value > 0) {
        if (value & 1)
            count++;
        value = value >> 1;
    }
    return count;
}