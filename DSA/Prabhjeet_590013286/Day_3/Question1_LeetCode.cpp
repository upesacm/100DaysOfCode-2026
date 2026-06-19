#include <vector>
using namespace std;

class Solution {
public:

    vector<int> plusOne(vector<int>& digits) {

        for (int i = digits.size() - 1; i >= 0; i--) {

            if (digits[i] < 9) { // Increment if digit is less than 9

                digits[i]++;
                return digits;
            }

            digits[i] = 0; // Carry generated
        }

        digits.insert(digits.begin(), 1); // Case like 999 -> 1000

        return digits;
    }
};