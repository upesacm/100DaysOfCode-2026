//Add one to the number represented by the array using an optimized approach
#include <bits/stdc++.h>
using namespace std;

vector<int> addOne(vector<int> &digits){
     int n = digits.size();

        for(int i = n-1; i >= 0 ; i-- ){
            if(digits[i] <9){
               digits[i]++;
               return digits;
            }
         digits[i]=0;
        }
        digits.insert(digits.begin(), 1);

        return digits;  
}

int main(){
     cout<<"enter the no. of elements in array"<< endl;
    int num ;
    cin>> num;
    vector<int> digits(num);
    cout<< "enter the elements of arrays" << endl;
    for(int i = 0; i < num ; i++){
        cin>> digits[i];}

       
vector<int>result = addOne(digits); 

cout<<"Result after adding one: ";
for(int digits: result){
    cout<<digits<<" ";
} 
return 0;   
};