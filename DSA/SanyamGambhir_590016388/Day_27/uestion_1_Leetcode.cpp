class Solution {
public:
    int compress(vector<char>& chars) {
        string s = "";
        int j = 0;
        int count = 0;
        while(j<chars.size()){
            count++;
            
            if(j + 1 == chars.size()  || chars[j] != chars[j + 1]){
                s += chars[j];
                if(count > 1){
                    s += to_string(count);
                }
                count = 0;
                
            }
            j++;

        }
        for (int k = 0; k < s.length(); k++) {
            chars[k] = s[k];
        }
        return s.length();
    }
};