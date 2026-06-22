class Solution {
public:
    bool isPalindrome(string s) {
        int n = s.size();
        if(n == 0  ||  n == 1){
            return true;
        }
        string s1 = "";

        for(int i = 0;i<n;i++){
            if(isalnum(s[i])){
                s1 +=(char)tolower(s[i]);
            }
        }
        int m = 0;
        int l = s1.length() - 1;

        while(m<l){
            if(s1[m] == s1[l]){
                m++;
                l--;
            }
            else{
                return false;
            }
        }
        return true;

    }
};