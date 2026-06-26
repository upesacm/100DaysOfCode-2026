#include <iostream>
using namespace std;
int main() {
    int arr[] = {12, 35, 1, 10, 34, 1};
    int n = sizeof(arr) / sizeof(arr[0]);
    int maxElement = arr[0];
    for(int i = 1; i < n; i++) {
        if(arr[i] > maxElement) {
            maxElement = arr[i];
        }
    }
    cout << "Largest element is: " << maxElement;
    return 0;
}
