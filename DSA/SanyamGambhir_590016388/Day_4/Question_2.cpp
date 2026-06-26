#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int>helper(vector<int>arr1,int i ,int j){
    while(i<j){
        swap(arr1[i],arr1[j]);
        i++;
        j--;
    }
    return arr1;
}


vector<int> rotatearray(vector<int> arr2,int step){
    
    
    
    
    arr2 = helper(arr2,0,step-1);
    arr2 = helper(arr2,step,arr2.size() - 1);
    arr2 = helper(arr2,0,arr2.size() - 1);
    
    
    return arr2;
}


int main() {
    
    int i = 0;
    vector<int> arr = {1, 2, 3, 4, 5};
    int j = arr.size();
    int step = 3;
    arr = rotatearray(arr,step);
    for(int i = 0;i<j;i++){
        cout<<arr[i];
    }

    return 0;
}