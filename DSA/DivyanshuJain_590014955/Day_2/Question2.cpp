#include<iostream>
#include<climits>
using namespace std;
int Max(int arr[],int n){
    int maxi=INT_MIN;
    for(int i=0;i<n;i++){
        maxi=max(arr[i],maxi);
    }
    return maxi;
}
int main(){
    int n;
    cout<<"Enter size: ";
    cin>>n;
    int arr[n];
    cout<<"Enter elements: ";
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    cout<<Max(arr,n);
}