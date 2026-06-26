#include <iostream>
#include <vector>
using namespace std;
int main() {
    int n;
    cin >> n;
    vector<int> arr(n);
    for(int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    int k;
    cin >> k;
    vector<int> rotated(n);
    for(int i = 0; i < n; i++) {
        rotated[(i + k) % n] = arr[i];
    }
    for(int i = 0; i < n; i++) {
        cout << rotated[i] << " ";
    }
    return 0;
}
