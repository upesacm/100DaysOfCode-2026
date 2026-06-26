#include <iostream>
#include <string>
#include <cctype>
using namespace std;

class solution{
    public:

    bool isVowel(char c){
        c= tolower(c);

        return (c=='a' || c=='e' || c=='i' || c=='o' || c=='u');
    }

    string transformString(string s){
            string result = "";

            for(char c: s){
                if(isVowel(c)){
                    continue;
                }
                else{
                    char lowerC= tolower(c);
                    result += '.';
                    result += lowerC;
            }
        }
        return result;
            
    }
};

int main(){
    solution obj;

    string s;
    cout<<"Enter string: ";
    cin>>s;

    cout<< obj.transformString(s)<<endl;

    return 0;
}