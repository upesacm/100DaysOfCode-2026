class Solution {
public:
    int lengthOfLastWord(string s) {
        int j=s.length()-1;
        while(j>=0 && s[j]==' ')
        {
            j--;
        }
        int count=0;
        for(j;j>=0;j--)
        {
            if(s[j]==' ')
            {
                break;
            }
            count++;

        }
        return count;
        
    }
};