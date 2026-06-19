#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
bool CheckEqualArray(vector<int>&arr1,vector<int>&arr2){
    if(arr1.size()==arr2.size()){
        sort(arr1.begin(),arr1.end());
        sort(arr2.begin(),arr2.end());
        for(int i = 0;i<arr1.size();i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
    return false;
}
int main(){
    vector<int>arr1 = {1,2,3,4,5};
    vector<int>arr2 = {1,2,3,4,5};
    cout<<CheckEqualArray(arr1,arr2);
}
