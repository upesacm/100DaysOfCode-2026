class Solution {
public:
    string addBinary(string a, string b) {

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        string result = "";

        while (i >= 0 || j >= 0 || carry) {

            int x = (i >= 0) ? a[i] - '0' : 0;
            int y = (j >= 0) ? b[j] - '0' : 0;

            int sum = x + y + carry;

            result += char((sum % 2) + '0');

            carry = sum / 2;

            i--;
            j--;
        }

        reverse(result.begin(), result.end());

        return result;
    }
};