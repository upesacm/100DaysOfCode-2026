#include<stdbool.h>
bool isIsomorphic(char* s, char* t)
{
    int map1[256]={0};
    int map2[256]={0};
    int i;

    for(i=0;s[i]!='\0';i++)
    {
        if(map1[s[i]]==0 && map2[t[i]]==0)
        {
            map1[s[i]]=t[i];
            map2[t[i]]=s[i];
        }
        else if(map1[s[i]]!=t[i] || map2[t[i]]!=s[i])
        {
            return false;
        }
    }
    return true;
}
