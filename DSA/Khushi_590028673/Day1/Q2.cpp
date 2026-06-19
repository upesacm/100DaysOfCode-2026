// Q2 Find Missing number in given array

#include <iostream>
#include <vector>
using namespace std;

int main(){
    int n;
    cin>>n; 

    vector<int>nums(n);
    int ans =n;

    for(int i=0; i<n; i++){
        cin>>nums[i];
        ans ^= i;
        ans ^= nums[i];
    }

    cout<<ans<<endl;

    return 0;
    
}