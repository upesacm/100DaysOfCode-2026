#include <bits/stdc++.h>
using namespace std;

void insertEl(int x, stack<int>& st){
    stack<int>temp;
    while(!st.empty()){
    temp.push(st.top());
    st.pop();
    }
    temp.push(x);
    while(!temp.empty()){
        st.push(temp.top());
        temp.pop();
    }

}
int main(){
    stack<int>st;
    cout<<"Enter 4 elements:"<<endl;
    int x = 0;
    for(int i = 0 ; i<4; i++){
    cin>>x;
    st.push(x);
    }
    
    cout<<"Enter the value to be inserted at the bottom";
    cin>>x;

    insertEl(x, st);

    cout << "Stack from top to bottom:\n";

while(!st.empty())
{
    cout << st.top() << " ";
    st.pop();
}

    return 0;
}