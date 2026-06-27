#include<iostream>
using namespace std;
int main()
{
    string str;
    getline(cin,str);
    int j=str.length()-1;
    for(int i=0;i<str.length()/2;i++)
    {
        char temp=str[i];
        str[i]=str[j];
        str[j]=temp;
        j--;
    }
    cout<<str;

    return 0;
}