#include <string>
#include <algorithm>

using namespace std;

class Solution {
public:
    string addBinary(string a, string b) {
        string result = "";
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        // Continue if there are digits left in either string OR a carry remains
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            
            // Add digit from string 'a' if available
            if (i >= 0) {
                sum += a[i] - '0'; 
                i--;
            }
            
            // Add digit from string 'b' if available
            if (j >= 0) {
                sum += b[j] - '0';
                j--;
            }
            
            // Append the remainder (0 or 1) to the result
            result += to_string(sum % 2);
            
            // Calculate the new carry (0 or 1)
            carry = sum / 2;
        }
        
        // The result was built backwards, so reverse it
        reverse(result.begin(), result.end());
        
        return result;
    }
};