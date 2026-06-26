#include <bits/stdc++.h>
using namespace std;

int main(){

    string s;
    cin>>s;
    set<char> st;
    for(char c:s){
        st.insert(c);
    }
    if(st.size()%2==0){
        cout<<"CHAT WITH HER!"<<endl;
    }
    else{
        cout<<"IGNORE HIM!"<<endl;
    }

    return 0;
}