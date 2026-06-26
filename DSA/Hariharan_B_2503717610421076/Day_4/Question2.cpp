#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
    int n,i,k;
    cout<<"Enter the number of elements : "; //Asking fo total elements
    cin>>n;
    
    int arr[n]; //decleared the array
    
    
    
    for(i=0;i<n;i++) //getting input for the array
    {
                    cout<<i+1<<" : ";
                    cin>>arr[i];
    }
    
    cout<<"Enter the value to shift the array : "; //getting the value to rotate the array to the right by k steps
    cin>>k;

    k=k%n;
     //rotate process
    reverse(arr, arr + n); 
    reverse(arr, arr + k);
    reverse(arr + k, arr + n);
    
    for(int i = 0; i < n; i++) //displying the rotated array
        cout << arr[i] << " ";
        
   

    return 0;
}

