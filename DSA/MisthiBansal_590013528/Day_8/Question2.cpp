#include <bits/stdc++.h>
using namespace std;

int main(){
    cout<< "Enter your string please" <<endl;
    string s;
    cin>> s;
    reverse(s.begin(), s.end());
    cout<< "Your reversed string is:"<< s;
    return 0;
}