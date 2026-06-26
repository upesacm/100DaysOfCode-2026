// got the idea from sorting in stacks --->using auxiliary stack --->pop, peek and push functions in stack 

class Solution {
public:
    
   
    vector<int> plusOne(vector<int>& digits) {
        int n=digits.size();
        vector<int>a;
        if(digits[n-1]!=9)
        {
            digits[n-1]+=1;
            return digits;
        }
        int m=n;
        while(m>=1 && digits[m-1]==9)
        {
            digits[m-1]=0;
            a.push_back(digits.back());
            digits.pop_back();
            m--;
        }
        if(digits.empty())
        {
            digits.push_back(1);   
        }
       else {
        digits[m-1]+=1;

        }
        while(!a.empty())
            {
                digits.push_back(a.back());
                a.pop_back();
            }
            return digits;
    }
};