#include <stdio.h>
#include <string.h>
#include <stdbool.h>


bool is_alnum (char c)
{
    if (c >= 'A' && c<= 'Z' || c >= 'a' && c<= 'z' || c>= '0' && c<= '9')
    {
        return true;
    }
    return false;
}



char lower (char c) 
{

        if (c >= 'A' &&  c<= 'Z')
        {
            return c + 32;
        }
    
    return c;
}



bool isPalindrome(char* s) 
{
    int left=0;
    int right= strlen(s)-1;

    while (left< right)
    {

        if (!is_alnum(s[left]))
        {
            left++;
        }

        else if (!is_alnum(s[right]))
        {
            right--; 
        }


        else
        {
            if ( lower(s[left]) != lower(s[right]) )
            {
                return false;
            }
            left++;
            right--;
        }

    }

    return true;
}