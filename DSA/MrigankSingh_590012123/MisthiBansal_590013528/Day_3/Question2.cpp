// Print the total number of occurrences of target in the array
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

    cout<<"Enter the target element: "<< endl;    
    int target ;
    cin>> target;
    int c = 0;
    for(int i = 0 ; i <n; i++){
        if( nums[i] == target)
        c++;
    }
cout<<"Occurence of your target element is: "<< c << endl;
    return 0;
}