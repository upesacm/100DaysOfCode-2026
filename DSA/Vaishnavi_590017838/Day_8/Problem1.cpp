class Solution {
public:
    bool isPalindrome(string s) {
        string cleaned = "";
        for(int i = 0; i < s.length(); i++) {
            if(isalnum(s[i])) {
                cleaned += tolower(s[i]);
            }
        }
        int left = 0;
        int right = cleaned.length() - 1;
        while(left < right) {
            if(cleaned[left] != cleaned[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
};
