#include<iostream>
using namespace std;
int sum_of_array(int arr[] , int n){
    int sum=0;
    for(int i=0;i<n;i++){
        sum+=arr[i];
    }
    return sum;
}
int main(){
    int n;
    cout<<"enter a number of element:";
    cin>>n;
    int arr[n];
    cout<<"enter elements: ";
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    cout<<"sum ="<<sum_of_array(arr ,n);
    return 0;
}