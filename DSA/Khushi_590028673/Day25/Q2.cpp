#include <iostream>
#include <vector>
using namespace std;

bool find(vector<int>&arr, int num){
    int left=0;
    int right=arr.size()-1;
    while(left<right){
        if(arr[left]+arr[right]==num){
            return true;
        }
        else{
            if(arr[left]+arr[right]<num){
                left++;
            }
            else{
                right--;
            }
        }
    }
    return false;
    
}

int main(){
    int n;
    cout<<"Enter the size of array: ";
    cin>>n;

    vector<int> arr(n);
    cout<<"Enter the elements: ";
    for(int i=0; i<n; i++){
        cin>>arr[i];
    }

    int num;
    cout<<"Enter the num: ";
    cin>>num;

    if(find(arr,num)){
        cout<<"True";
    }

    else{
        cout<<"False";
    }

    return 0;
}