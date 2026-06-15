#include <iostream>
using namespace std;

int main() {

    int arr[] = {12, 35, 1, 10, 34, 1};  

    int n = sizeof(arr) / sizeof(arr[0]); // Total number of elements

    int sum = 0;                          

    for (int i = 0; i < n; i++) {
        sum += arr[i];                    // Adding each element
    }

    cout << sum;                          

    return 0;                             
}