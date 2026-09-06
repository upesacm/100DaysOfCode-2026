#include <bits/stdc++.h>
using namespace std;
int main(){

    cout<<"enter the no. of elements in array"<< endl;
    int n ;
    cin>> n;
    vector<int> nums(n);
    cout<< "enter the elements of arrays" << endl;
    for(int i = 0; i < n ; i++){
        cin>> nums[i];}

        int larg = nums[0];

    for(int i = 0; i<n ; i++){
        if( nums[i] > larg){
            larg = nums[i];
        }

    } 
cout<< "the largest element in the array is :"<< larg << endl;}
