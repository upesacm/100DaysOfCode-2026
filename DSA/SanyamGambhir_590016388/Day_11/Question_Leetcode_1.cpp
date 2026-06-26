class Solution {
public:
    bool isIsomorphic(string s, string t) {
        int S[256] = {0};
        int T[256] = {0};

        int n = s.length();

        for(int i = 0;i<n;i++){
            if(S[s[i]] != T[t[i]]){
                return false;
            }

            S[s[i]] = i+ 1;
            T[t[i]] = i + 1;
        }

        return true;

    }
};
