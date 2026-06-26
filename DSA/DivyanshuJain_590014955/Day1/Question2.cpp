#include<iostream>
using namespace std;
int sum(int arr[],int n){
    int total=0;
    for(int i=0;i<n;i++){
        total+=arr[i];
    }
    return total;
}
int main(){
    int n;
    cout<<"Enter size of array: ";
    cin>>n;
    int arr[n];
    cout<<"Enter Elements: ";
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    cout<<"The sum is: "<<sum(arr,n);
}