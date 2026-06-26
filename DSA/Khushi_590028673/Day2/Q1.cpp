// Q1 Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

#include <iostream>
#include <vector>
using namespace std;

int removeElement(vector<int> &nums, int val){
    int j=0;

    for(int i=0; i<nums.size(); i++){
        if(nums[i] != val){
            nums[j]= nums[i];
            j++;
        }
    }

    return j;
}
int main(){
    int n;
    cin>> n;

    vector<int> nums(n);

    for(int i=0;i<n;i++){
        cin>>nums[i];
    }


    int val;
    cin >> val;

    int k = removeElement(nums, val);

    cout << k << endl;

    cout << "Modified array: ";
    for (int i = 0; i < k; i++) {
        cout << nums[i] << " ";
    }
    cout << endl;

    return 0;

}