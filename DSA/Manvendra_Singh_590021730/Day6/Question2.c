// Function to find the union of two sorted arrays
// The function takes two sorted arrays a and b, their sizes n1 and n2, and a pointer to an integer size to store the size of the resulting union array.
int* unionArrays(int* a, int n1, int* b, int n2, int* size) {
    int *res = malloc((n1 + n2) * sizeof(int));
    int i = 0, j = 0, k = 0;

    while (i < n1 && j < n2) {
        while (i > 0 && i < n1 && a[i] == a[i-1]) i++;
        while (j > 0 && j < n2 && b[j] == b[j-1]) j++;

        if (i == n1 || j == n2) break;

        if (a[i] < b[j]) res[k++] = a[i++];
        else if (a[i] > b[j]) res[k++] = b[j++];
        else { res[k++] = a[i++]; j++; }
    }

    while (i < n1) {
        if (i == 0 || a[i] != a[i-1]) res[k++] = a[i];
        i++;
    }

    while (j < n2) {
        if (j == 0 || b[j] != b[j-1]) res[k++] = b[j];
        j++;
    }

    *size = k;
    return res;
}