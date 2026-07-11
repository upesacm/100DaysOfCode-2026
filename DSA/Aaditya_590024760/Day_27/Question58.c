#include <stdio.h>

int countSubarrays(int* arr, int n, int l, int r) {
    int count = 0;
    
    for (int i = 0; i < n; i++) {
        int maxVal = arr[i];
        
        for (int j = i; j < n; j++) {
            if (arr[j] > maxVal)
                maxVal = arr[j];
            
            if (maxVal >= l && maxVal <= r)
                count++;
            else if (maxVal > r)
                break;
        }
    }
    
    return count;
}

int main() {
    int n, l, r;

    printf("Enter size of array: ");
    scanf("%d", &n);

    int arr[n];
    printf("Enter elements: ");
    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    printf("Enter l and r: ");
    scanf("%d %d", &l, &r);

    printf("Count of subarrays: %d\n", countSubarrays(arr, n, l, r));

    return 0;
}
