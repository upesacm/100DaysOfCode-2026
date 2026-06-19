#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int counttarget(vector<int> &digits,int target){

    int n = digits.size();
    int count = 0;

    for(int i = 0;i<n;i++){
        if(digits[i] == target){
            count++;
        }
    }

    cout<<"Count of "<<target<<" is: "<<count<<endl;

    return count;
}


int main(){

    vector<int> digits = {1,2,3,4,5,4,3,2,1};
    int target = 4;

    counttarget(digits,target);

    return 0;
}