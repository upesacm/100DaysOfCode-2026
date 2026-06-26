#include<iostream>
using namespace std;
int main()
{
   int n[100],k,p;
   cout<<"Enter the number of arry elements";
   cin>>p;
   cout<<"Enter the values";
   for(int i=0;i<p;i++)
   {
       cin>>n[i];
       }
    cout<<"Enter the number to rotate";
    cin>>k;
    int temp[100];
    k=k%p;
    for(int i=0;i<p;i++)
    {
        temp[(i+k)%p]=n[i];
        }
        for(int j=0;j<p;j++)
        {
            cout<<temp[j]<<" ";
            }
    return 0;
}
