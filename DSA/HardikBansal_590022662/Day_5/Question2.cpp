#include<iostream>
#include<vector>
using namespace std;
void array_formation(vector<int>& array)
{
    int x;
    char choice;
    do{
        cout<<"want to add more elements(y/n):";
        cin>>choice;
        if(choice=='y')
        {
            cout<<"Enter no:";
            cin>>x;
            array.push_back(x);
        }
        
    }while(choice=='y');
}
int main()
{
    vector<int>arr1;
    vector<int>arr2;
    array_formation(arr1);
    array_formation(arr2);
    if(arr1.size()!=arr2.size())
    {
        cout<<"Not identical";
        return 0;
    }
    for(int i=0;i<arr1.size();i++)
    {
        if(arr1[i]!=arr2[i])
        {
            cout<<"Not identical";
            return 0;
        }
    }
    cout<<"Identical";
    
    
    return 0;
}