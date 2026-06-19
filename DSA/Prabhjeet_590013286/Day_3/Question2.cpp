#include <iostream>
using namespace std;

int main() {

    int arr[] = {1, 2, 2, 2, 3, 4, 5};

    int target = 2;

    int n = sizeof(arr) / sizeof(arr[0]); // Total number of elements

    int count = 0;

    for (int i = 0; i < n; i++) {

        if (arr[i] == target) { // Counting target occurrences
            count++;
        }
    }

    cout << count;

    return 0;
}