#include <iostream>
using namespace std;

int main() {

    int arr[] = {1, 2, 3, 4};

    int k = 3;

    int n = sizeof(arr) / sizeof(arr[0]); // Total number of elements

    k = k % n; // Handling k greater than array size

    int rotated[n];

    for (int i = 0; i < n; i++) {

        rotated[(i + k) % n] = arr[i]; // Rotating array to the right
    }

    for (int i = 0; i < n; i++) {

        cout << rotated[i] << " ";
    }

    return 0;
}