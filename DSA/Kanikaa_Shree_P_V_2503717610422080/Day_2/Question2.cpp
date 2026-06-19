#include<iostream>
using namespace std;
int main()
{
    int a[1000],i,max,n=0;
    while(cin>>a[n])
    {
        n++;
    }
    max=a[0];
    for(i=0;i<n;i++)
    {
        if(a[i]>max)
            max=a[i];
    }
    cout<<max;
    return 0;
}
