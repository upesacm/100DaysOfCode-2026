#include<iostream>
#include<vector>
using namespace std;
vector<int>plusOne(vector<int>&digits){
    int n = digits.size();
    int i=n-1;
    while(i>=0){
        if(digits[i]<9){
            digits[i]+=1;
            return digits;
        }
        else{
            digits[i]=0;
            i--;
        }
    }
    digits.insert(digits.begin(),1);
    return digits;
}
int main(){
    vector<int>digits = {9,9,9};
    vector<int>ans = plusOne(digits);
    for(int i=0;i<ans.size();i++){
        cout<<ans[i]<<" ";
    }
    return 0;
}