class Solution {
public:
    bool isPalindrome(string s) {
        int j=0;
        for(int i=0;i<s.length();i++)
        {
            if(isupper(s[i]))
            {
                s[i]=tolower(s[i]); 
            }
            if(isalnum(s[i]))
            {
                s[j++]=s[i];
            }
        }
        s.resize(j);
        j--;
        for(int i=0;i<s.length()/2;i++)
        {
            if(s[i]!=s[j])
            {
                return false;
            }
            j--;
        }
        return true;

        
    }
};