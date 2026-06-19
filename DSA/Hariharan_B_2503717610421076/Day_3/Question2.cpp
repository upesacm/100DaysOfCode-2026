#include<iostream>
using namespace std;

int main()
{
    int n, i, target;

    cout<<"Enter the number of elements : ";
    cin>>n;
    cout<<endl;

    int arr[n];

    for(i=0;i<n;i++)
    {
        cout<<"Enter the element "<<i+1<<" : ";
        cin>>arr[i];
    }

    cout<<"\nEnter the target value : ";
    cin>>target;

    int first = -1, last = -1;
    int low, high, mid;

    low = 0;
    high = n - 1;

    while(low <= high)
    {
        mid = (low + high) / 2;

        if(arr[mid] == target)
        {
            first = mid;
            high = mid - 1;
        }
        else if(arr[mid] < target)
        {
            low = mid + 1;
        }
        else
        {
            high = mid - 1;
        }
    }

    low = 0;
    high = n - 1;

    while(low <= high)
    {
        mid = (low + high) / 2;

        if(arr[mid] == target)
        {
            last = mid;
            low = mid + 1;
        }
        else if(arr[mid] < target)
        {
            low = mid + 1;
        }
        else
        {
            high = mid - 1;
        }
    }

    int occ = 0;

    if(first != -1)
    {
        occ = last - first + 1;
    }

    cout<<"\nTotal number of occurrences of "
        <<target<<" in the array : "
        <<occ<<endl;
     

    return 0;
}
