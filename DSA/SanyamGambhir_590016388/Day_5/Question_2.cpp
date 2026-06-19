#include<iostream>
#include<algorithm>
#include<vector>
#include<map>
using namespace std;

bool checkequal(vector<int> arr1, vector<int> arr2){

    if(arr1.size() != arr2.size()){
        cout<<"Arrays are not equal"<<endl;
        return false;
    }
    int n = arr1.size();
    int m = arr2.size();

    map<int,int> mp1;

    for(int i=0; i<n; i++){
        mp1[arr1[i]]++;
    }

    for(int i = 0; i<m; i++){
        mp1[arr2[i]]--;
    }

    for(auto it: mp1){
        
        if(it.second != 0){
            cout<<"Arrays are not equal"<<endl;
            return false;
        }
    }
    cout<<"Arrays are equal"<<endl;
    return true;


}


int main(){

    vector<int> arr1 = {1, 2, 5,4, 5};
    vector<int> arr2 = {1, 2, 3, 4, 5};

    checkequal(arr1, arr2);


    return 0;

}
