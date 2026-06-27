#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Solution{
    public:

    vector<int> numberOfLines(vector<int>&widths, string s){
        int lines=1;
        int currentwidth=0;
        for(char ch:s){
            int w=widths[s[ch]-'a'];

            if(currentwidth+w<=100){
                currentwidth+=w;
            }
            else{
                lines++;
                currentwidth=w;
            }
        }

        return {lines, currentwidth};
    }
};


int main(){
    vector<int>widths={10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};

    string s="abcefghijklmnopqrstuvwxyz";

    Solution obj;

    vector<int>result= obj.numberOfLines(widths, s);

    cout<<"number of lines: "<<result[0]<<endl;
    cout<<"width of last line: "<< result[1]<<endl;


    return 0;
}