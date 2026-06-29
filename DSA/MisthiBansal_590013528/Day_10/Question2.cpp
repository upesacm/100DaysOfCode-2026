//Print "CHAT WITH HER!" if the number of distinct characters is even, otherwise print 
//"IGNORE HIM!"
#include <bits/stdc++.h>
using namespace std;

int main(){
cout<<"Enter your string"<< endl;
    string s ;
    cin>> s;
  
 set<char>st;
 
 for(int i = 0; i < s.length();i++){
    st.insert(s[i]);
 }
 int count = st.size();
 if(count%2 ==0){
    cout<<"CHAT WITH HER!";
 }
 else
  cout<<"IGNORE HIM!";
    return 0;
}