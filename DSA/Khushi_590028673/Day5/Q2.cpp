// Q2 Check Equal Arrays


#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

bool areEqual(vector<int>& a, vector<int>& b) {
    if (a.size() != b.size()) {
        return false;
    }

    unordered_map<int, int> freq;

    // Count frequencies in first array
    for (int num : a) {
        freq[num]++;
    }

    // Decrease frequencies using second array
    for (int num : b) {
        if (freq.find(num) == freq.end() || freq[num] == 0) {
            return false;
        }
        freq[num]--;
    }

    return true;
}

int main() {
    int n;

    cout << "Enter size of arrays: ";
    cin >> n;

    vector<int> a(n), b(n);

    cout << "Enter elements of first array: ";
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }

    cout << "Enter elements of second array: ";
    for (int i = 0; i < n; i++) {
        cin >> b[i];
    }

    cout << (areEqual(a, b) ? "true" : "false") << endl;

    return 0;
}
