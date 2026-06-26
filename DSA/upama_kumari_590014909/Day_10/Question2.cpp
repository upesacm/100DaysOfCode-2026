#include<iostream>
#include<set>
#include<string>
using namespace std;

int main(){
    set<char>s;
    string a ="abc";
    for(int i=0;i < a.length();i++){
        s.insert(a[i]);
    }
    if(s.size() % 2 == 0){
        cout<<"CHAT WITH HER";
    }else{
        cout<<"IGNORE HIM";
    }

}