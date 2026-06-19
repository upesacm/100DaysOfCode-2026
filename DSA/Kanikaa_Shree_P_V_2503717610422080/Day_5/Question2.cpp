#include<iostream>
using namespace std;
int main()
{
    int a[100],b[100],n,q;
    cout<<"Enter the number of elements:";
    cin>>n;
    cout<<"Enter the values for first:";
    for(int i=0;i<n;i++)
    {
        cin>>a[i];
        }
     cout<<"Enter the values for second:";
    for(int i=0;i<n;i++)
    {
        cin>>b[i];
        } 
    for(int i=0;i<n;i++)
    { q=0;
        for(int j=0;j<n;j++)
        {
            if(a[i]==b[j])
            {
                q=1;
                }
            }
        
        }
         if(q==0)
           cout<<"false";
        if(q==1)
            cout<<"true";
    return 0;
    }