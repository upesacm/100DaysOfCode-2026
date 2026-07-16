#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    int compress(vector<char>& chars) {
        int n = chars.size();
        int i = 0;
        int write = 0;

        while (i < n) {
            int j = i;

            while (j < n && chars[j] == chars[i]) {
                j++;
            }

            chars[write++] = chars[i];

            int count = j - i;

            if (count > 1) {
                string s = to_string(count);
                for (char c : s) {
                    chars[write++] = c;
                }
            }

            i = j;
        }

        return write;
    }
};

int main() {
    Solution obj;

    vector<char> chars = {'a','a','b','b','c','c','c'};

    int newLength = obj.compress(chars);

    cout << "Compressed Array: ";
    for (int i = 0; i < newLength; i++) {
        cout << chars[i] << " ";
    }

    cout << "\nLength = " << newLength << endl;

    return 0;
}
