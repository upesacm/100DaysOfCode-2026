#include<iostream>
using namespace std;
int main()
{
    int n,target,freq=0;
    cin>>n;
    int arr[n];
    for(int i=0;i<n;i++)
    {
        cin>>arr[i];
    }
    cin>>target;
    for(int i=0;i<n;i++)
    {
        if(arr[i]==target)
        {
            freq++;
            i++;
            while(i<n && arr[i]==target)
            {
                freq++;
                i++;
            }
            cout<<freq;
            return 0;
        }
    }
    cout<<freq;
   
    return 0;
}