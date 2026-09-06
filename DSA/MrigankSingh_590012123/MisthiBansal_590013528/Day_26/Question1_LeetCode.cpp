#include <bits/stdc++.h>
using namespace std;

bool triplets(vector<int> &arr){
 int i = 0;
 int j = 1;
 int k = 2;

 while( i < arr.size() ||){
    if( arr[i]== (arr[j]+arr[k]))
    {return true;}
    j++;
    k++;
    i++
 }
}
int main(){
     int n;

    cout << "Enter the size of the array: ";
    cin >> n;

    vector<int> arr(n);

    cout << "Enter the array elements: ";
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

 
    return 0;
}