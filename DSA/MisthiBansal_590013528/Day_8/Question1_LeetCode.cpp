//Valid Palindrome
//LeetCode 125
#include <bits/stdc++.h>
using namespace std;

int main(){
    bool isPalindrome(string s) {

   string clean;
   for(int i = 0 ; i < s.length(); i++){
    if( isalnum( s[i]))
        { clean.push_back(s[i]);
           }
   }

   for(int i = 0, j = clean.length()-1; i <= j ; i++ ,j--){
         if(tolower(clean[i]) != tolower(clean[j]))
            return false;
         }
    return true;
   }

};