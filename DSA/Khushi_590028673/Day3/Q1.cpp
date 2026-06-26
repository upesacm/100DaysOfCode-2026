// Q1 PLUS ONE 

#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int n = digits.size() - 1;

        while (n >= 0) {
            if (digits[n] < 9) {
                digits[n]++;
                return digits;
            }
            digits[n] = 0;
            n--;
        }

        digits.insert(digits.begin(), 1);
        return digits;
    }
};

int main() {
    Solution sol;

    int n;
    cout << "Enter number of digits: ";
    cin >> n;

    vector<int> digits(n);

    cout << "Enter digits (space-separated): ";
    for (int i = 0; i < n; i++) {
        cin >> digits[i];
    }

    vector<int> result = sol.plusOne(digits);

    cout << "Result after plus one: ";
    for (int d : result) {
        cout << d << " ";
    }
    cout << endl;

    return 0;
}
