// leetcode problem 455
// Assign Cookies

void merge(int arr[], int left, int mid, int right) {
    int leftSize = mid - left + 1;
    int rightSize = right - mid;

    int leftArray[leftSize];
    int rightArray[rightSize];

    for(int i = 0; i < leftSize; i++)
        leftArray[i] = arr[left + i];

    for(int i = 0; i < rightSize; i++)
        rightArray[i] = arr[mid + 1 + i];

    int leftIndex = 0;
    int rightIndex = 0;
    int currentIndex = left;

    while(leftIndex < leftSize && rightIndex < rightSize) {
        if(leftArray[leftIndex] <= rightArray[rightIndex]) {
            arr[currentIndex] = leftArray[leftIndex];
            leftIndex++;
        }
        else {
            arr[currentIndex] = rightArray[rightIndex];
            rightIndex++;
        }
        currentIndex++;
    }
    while(leftIndex < leftSize) {
        arr[currentIndex] = leftArray[leftIndex];
        leftIndex++;
        currentIndex++;
    }
    while(rightIndex < rightSize) {
        arr[currentIndex] = rightArray[rightIndex];
        rightIndex++;
        currentIndex++;
    }
}

void mergeSort(int arr[], int left, int right) {
    if(left < right) {
        int mid = (left + right) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }
}

int findContentChildren(int* g, int gSize, int* s, int sSize) {
    mergeSort(g, 0, gSize - 1);
    mergeSort(s, 0, sSize - 1);

    int child = 0;
    int cookie = 0;

    while(child < gSize && cookie < sSize) {
        if(g[child] <= s[cookie]) {
            child++;
        }
        cookie++;
    }
    return child;
}