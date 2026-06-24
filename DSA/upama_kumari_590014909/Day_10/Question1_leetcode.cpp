#include<iostream>
#include<string>
using namespace std;

int matchingstring(string s1,string s2){

    int m = s1.length();
    int n = s2.length();

    for(int i=0;i<=m-n;i++){
        for(int j=0;i<n;j++){
            if(s1[i+j]!=s2[j]){
                break;
            }
            if(j==n-1){
                return i;
            } 
        }   
    }
    return -1;
}
int main(){
    string s1="sadofsad";
    string s2 = "sad";
    cout<<matchingstring(s1,s2);
}



