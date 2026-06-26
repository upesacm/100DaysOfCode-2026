int largest(int[] arr) {
    int max = arr[0];
    for (int n : arr) if (n > max) max = n;
    return max;
}