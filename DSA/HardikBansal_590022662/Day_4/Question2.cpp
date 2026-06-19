#include <iostream>
using namespace std;
void reverse(int arr[],int start,int end)
{
    while(start<end)
    {
        int temp=arr[start];
        arr[start]=arr[end];
        arr[end]=temp;
        start++;
        end--;
        
    }
    

}

int main()
{
    int arr[]={1,2,3,4};
    int k,n=sizeof(arr)/sizeof(arr[0]);
    cin>>k;
    if(k>n)
    {
        k=k%n;
    }
    reverse(arr,0,n-1);
    reverse(arr,0,k-1);
    reverse(arr,k,n-1);
    for(int i=0;i<n;i++)
    {
        cout<<arr[i]<<" ";
    }
    return 0;
}