#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;
int main(){

    string s = "My Name Is Sanyam";
    int i = 0;
    string s1 = "";
    while(i!=s.length()){
        if(s[i] == ' '){
            i++;
        }
        else{
            s1 += s[i];
            i++;
        }
    }
    cout<<s1;

    return 0;
}