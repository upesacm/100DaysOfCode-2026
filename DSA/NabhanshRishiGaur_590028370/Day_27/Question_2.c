long long countSubarrays(int* arr, int arrSize, int l, int r) {
    long long count = 0;

    for (int i = 0; i < arrSize; i++) {
        int maximum = arr[i];

        for (int j = i; j < arrSize; j++) {
            if (arr[j] > maximum) {
                maximum = arr[j];
            }

            if (maximum >= l && maximum <= r) {
                count++;
            }
        }
    }

    return count;
}
