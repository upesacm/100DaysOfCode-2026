#include <iostream>
#include <stack>
#include <vector>
using namespace std;

vector<int> finalprices(vector<int> &prices){
    int n=prices.size();
    vector<int>ans=prices;
    stack<int>st;

    for(int i=n-1; i>=0; i--){
        while(!st.empty() && prices[st.top()]<=prices[i]){
            st.pop();
        }

        if(!st.empty()){
            ans[i]= prices[st.top()];
        }
        else{
            ans[i]=-1;
        }
        st.push(i);
    }

    return ans;
}
int main(){
    vector<int>prices ={8,4,6,2,3};
    vector<int> result=finalprices(prices);

    cout<<"Final Price: ";
    for(int price: result){
        cout<<price<<" ";
    }
    cout<<endl;

    return 0;
}