#include <iostream>
#include <vector>
using namespace std;
int main() {
    vector<int> a = {1, 2, 3, 4, 5};
    vector<int> b = {1, 2, 3, 6, 7};
    vector<int> result;
    int i = 0;
    int j = 0;
    while(i < a.size() && j < b.size()) {
        if(a[i] < b[j]) {
            if(result.empty() || result.back() != a[i]) {
                result.push_back(a[i]);
            }
            i++;
        }
        else if(a[i] > b[j]) {
            if(result.empty() || result.back() != b[j]) {
                result.push_back(b[j]);
            }
            j++;
        }
        else {
            if(result.empty() || result.back() != a[i]) {
                result.push_back(a[i]);
            }
            i++;
            j++;
        }
    }
    while(i < a.size()) {
        if(result.back() != a[i]) {
            result.push_back(a[i]);
        }
        i++;
    }
    while(j < b.size()) {
        if(result.back() != b[j]) {
            result.push_back(b[j]);
        }
        j++;
    }
    for(int num : result) {
        cout << num << " ";
    }
    return 0;
}
