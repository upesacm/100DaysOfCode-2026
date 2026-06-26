#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int main() {
    vector<int> a = {1, 2, 5, 4, 0};
    vector<int> b = {2, 4, 5, 0, 1};
    sort(a.begin(), a.end());
    sort(b.begin(), b.end());
    bool same = true;
    for(int i = 0; i < a.size(); i++) {
        if(a[i] != b[i]) {
            same = false;
            break;
        }
    }
    if(same) {
        cout << "true";
    }
    else {
        cout << "false";
    }
    return 0;
}
