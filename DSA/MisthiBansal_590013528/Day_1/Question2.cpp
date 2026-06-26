#include <bits/stdc++.h>
using namespace std;

int main(){
    
    cout<<"Enter the value of n: ";
    int n =0;  
    cin>> n;      
   
    vector<int> nums(n);
    cout<<"Enter " << n << " numbers: ";
    for(int i = 0; i < n; i++){
        cin>>nums[i];
    }

    sort(nums.begin(), nums.end());
    
    int i = 0;
    while( i <n){
     if(nums[i]== i)
      i++;

    else
    return i;
    }
    return n;}