#include<iostream>
#include<stack>
class Solution{
    vector<int>visiblePeople(int n,vector<int>&arr){
        vector<int>ans(n,0);
        stack<int>st;

        for(int i=n-1;i>=0;i--){
            while(!st.empty()&&st.top()<arr[i]){
                ans[i]++;
                st.pop();
            }
            if(!st.empty()){
                ans[i]++;
            }
            st.push(arr[i]);
        }
        return ans;
    }
};
int main(){
    int n=6;
    vector<int>arr = {10,6,8,5,11,9};

    Solution obj;
    vector<int>ans = obj.visiblePeople(n,arr);

    for(int x:ans)
    cout<<x<<"";

    return 0;

}