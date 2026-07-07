#include <iostream>
#include <vector>
using namespace std;

void moveZeroes(vector<int>& nums) {
    int index = 0;
    for(int i = 0; i < nums.size(); i++) {
        if(nums[i] != 0) {
            swap(nums[index], nums[i]);
            index++;
        }
    }
}
void printArray(vector<int>& nums) {
    for(int value : nums)
        cout << value << " ";
    cout << endl;
}

int main() {
    int n;
    cout << "Enter the size of the array: ";
    cin >> n;
    vector<int> nums(n);
    cout << "Enter the elements: ";
    for(int i = 0; i < n; i++)
        cin >> nums[i];

    moveZeroes(nums);
    cout << "Array after moving zeroes: ";
    printArray(nums);
    return 0;
}
