//Q1 An array of integers.
// Your Task: Find the sum of all array elements using an optimized approach.

#include <iostream>
#include <vector>
using namespace std;

int main(){
    int n;
    cin>>n;

    vector<int> arr(n);

    for(int i=0; i<n; i++){
        cin>>arr[i];
    }

    long long sum=0;

    for(int i=0; i<n; i++){
        sum+=arr[i];
    }

    cout<<sum<<endl;

    return 0;
}