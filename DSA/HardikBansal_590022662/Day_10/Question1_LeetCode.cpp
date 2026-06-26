class Solution {
public:
    int strStr(string haystack, string needle) {
        int p=-1;
        for(int i=0;haystack[i]!='\0';i++)
        {
            if(needle[0]==haystack[i])
            {
                int j=0;
                int k=i;
                p=i;
                while(needle[j]!='\0')
                {
                    if(haystack[k]=='\0')
                    {
                        p=-1;
                        break;
                    }
                    if(needle[j]!=haystack[k])
                    {
                        p=-1;
                        break;
                    }
                    j++;
                    k++;
                }
            }
            if(p!=-1)
            {
                return p;
            }
        }
        return p;
        
    }
};