#include<iostream>
using namespace std;
int main()
{
    string str;
   // int count;
    getline(cin,str);
    for(int i=0;i<str.length();i++)
    {
         if(str[i]==' ')
         {
            int j=i+1;
            if(j<str.length())
            {
                int p=i;
                int k=j;
                while(k<str.length())
                {
                    str[p++]=str[k++];
                }  
            }
            else{
                str[i]='\0';
            }
            str.resize(str.length()-1);
            i--; // to check for cases where  more than one space are together
         }
    }
    return 0;
}