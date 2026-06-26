#include <bits/stdc++.h>
using namespace std;

 int removeElement(vector<int>& nums, int val) {
        int i = 0;
        for(int j = 0; j < nums.size(); j++)
        {
            if(nums[j] != val)
            {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

int main()
{    
cout<<"enter the total no. of array"<< endl;
int n;
cin>>n;
vector<int> nums(n);
cout<<"enter the elements of array"<< endl;
for(int i=0;i<n;i++)
{
    cin>>nums[i];   
}

 cout<<"enter the value to be removed"<< endl;
int val;

cin>> val;

 int k = removeElement(nums,val);
 cout<<"new length of array after removing th elements is :"<< k << endl;

};