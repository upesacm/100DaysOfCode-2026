#include <iostream>
#include <set>
using namespace std;

int main() {

    int arr1[] = {1, 2, 3, 4};
    int arr2[] = { 4, 5, 6, 7 };

    int n1 = sizeof(arr1) / sizeof(arr1[0]);
    int n2 = sizeof(arr2) / sizeof(arr2[0]);

    set<int> unionSet;

    for (int i = 0; i < n1; i++) {

        unionSet.insert(arr1[i]); // Insert elements of first array
    }

    for (int i = 0; i < n2; i++) {

        unionSet.insert(arr2[i]); // Insert elements of second array
    }

    for (int num : unionSet) {

        cout << num << " ";
    }

    return 0;
}