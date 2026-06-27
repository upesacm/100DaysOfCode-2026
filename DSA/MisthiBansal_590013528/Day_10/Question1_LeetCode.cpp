// Find the Index of the First Occurrence in a String
// LeetCode #28 using KMP Algorithm
//used kmp algorithm

#include <bits/stdc++.h>
using namespace std;

int strStr(string haystack, string needle)
{
    int n = haystack.size();
    int m = needle.size();

    if(m == 0)
        return 0;

    // Build LPS array
    vector<int> lps(m, 0);

    int len = 0;
    int i = 1;

    while(i < m)
    {
        if(needle[i] == needle[len])
        {
            len++;
            lps[i] = len;
            i++;
        }
        else
        {
            if(len != 0)
            {
                len = lps[len - 1];
            }
            else
            {
                lps[i] = 0;
                i++;
            }
        }
    }

    // Search using KMP
    int h = 0; // haystack pointer
    int p = 0; // needle pointer

    while(h < n)
    {
        if(haystack[h] == needle[p])
        {
            h++;
            p++;
        }

        if(p == m)
        {
            return h - p;
        }
        else if(h < n && haystack[h] != needle[p])
        {
            if(p != 0)
            {
                p = lps[p - 1];
            }
            else
            {
                h++;
            }
        }
    }

    return -1;
}

int main()
{
    string haystack;
    string needle;

    cout << "Enter haystack string: ";
    cin >> haystack;

    cout << "Enter needle string: ";
    cin >> needle;

    int ans = strStr(haystack, needle);

    cout << "First occurrence index: " << ans << endl;

    return 0;
}