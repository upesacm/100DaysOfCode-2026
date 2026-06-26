#include<iostream>
#include<string>
using namespace std;

string reverseString(string s){
    string result = "";
    int n = s.length() - 1;
    for(int i=n;i>=0;i--){
        result = result+s[i];
    }
    return result;
}

int main(){
    string s1 = "car";

    cout<<reverseString(s1);

    return 0;
}