#include<iostream>
#include<string>
using namespace std;

string transform(string s){
    string vowels = "aeiouAEIOU";
    string result ="";

    for(char ch:s){
        if(vowels.find(ch) == string::npos){
            result+=",";
            result+=tolower(ch);
        }
    }
    return result;
}
int main(){
    cout<<transform("Hello");
}