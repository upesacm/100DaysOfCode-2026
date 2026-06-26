#include <iostream>
#include <vector>

using namespace std;

vector<int> findUnion(vector<int>& a, vector<int>& b) {
    vector<int> result;

    int i = 0, j = 0;
    int n = a.size();
    int m = b.size();

    while (i < n && j < m) {
        if (a[i] < b[j]) {
            if (result.empty() || result.back() != a[i]) {
                result.push_back(a[i]);
            }
            i++;
        }
        else if (a[i] > b[j]) {
            if (result.empty() || result.back() != b[j]) {
                result.push_back(b[j]);
            }
            j++;
        }
        else {
            if (result.empty() || result.back() != a[i]) {
                result.push_back(a[i]);
            }
            i++;
            j++;
        }
    }

    while (i < n) {
        if (result.empty() || result.back() != a[i]) {
            result.push_back(a[i]);
        }
        i++;
    }

    while (j < m) {
        if (result.empty() || result.back() != b[j]) {
            result.push_back(b[j]);
        }
        j++;
    }

    return result;
}

int main() {
    int n, m;

    cout << "Enter size of first array: ";
    cin >> n;

    vector<int> a(n);
    cout << "Enter elements of first sorted array: ";
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }

    cout << "Enter size of second array: ";
    cin >> m;

    vector<int> b(m);
    cout << "Enter elements of second sorted array: ";
    for (int i = 0; i < m; i++) {
        cin >> b[i];
    }

    vector<int> unionArray = findUnion(a, b);

    cout << "Union: [";
    for (int i = 0; i < unionArray.size(); i++) {
        cout << unionArray[i];
        if (i != unionArray.size() - 1)
            cout << ",";
    }
    cout << "]" << endl;

    return 0;
}
