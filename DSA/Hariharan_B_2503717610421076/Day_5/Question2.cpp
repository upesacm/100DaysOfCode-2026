#include<iostream>
#include<algorithm>
using namespace std;

int main()
{
    int n,i,x=1;

    cout<<"Enter the size of the array : ";
    cin>>n;

    int a[n], b[n];

    cout<<"Enter for array 'a'"<<endl;

    for(i=0;i<n;i++)
    {
        cout<<i+1<<" : ";
        cin>>a[i];
    }

    cout<<"Enter for array 'b'"<<endl;

    for(i=0;i<n;i++)
    {
        cout<<i+1<<" : ";
        cin>>b[i];
    }

    sort(a, a+n);
    sort(b, b+n);

    for(i=0;i<n;i++)
    {
        if(a[i] != b[i])
        {
            x = 0;
            break;
        }
    }

    if(x)
        cout<<"true"<<endl;
    else
        cout<<"false"<<endl;

    return 0;
}
