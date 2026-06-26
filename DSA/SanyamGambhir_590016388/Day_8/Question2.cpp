#include<iostream>
#include<vector>
#include<string>
using namespace std;

string reversestr(string s, int n){
    int i = 0;
    int j = n - 1;

    while(i<j){
        swap(s[i],s[j]);
        i++;
        j--;
    }
    return s;
}

int main(){
    string s = "Sanyam";
    int n = s.length();

    string s1 = reversestr(s,n);
    
    cout<<s1;

    return 0;
}