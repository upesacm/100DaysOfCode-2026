#include <iostream>
#include <queue>
using namespace std;

int TimeTaken(int n, int x){
    queue<int> q1;

    for(int i=1; i<=n; i++){
        q1.push(i);
    }

    int count=0;

    while(!q1.empty()){
        int person = q1.front();
        q1.pop();
        count++;

        if(person ==x){
            return count;
        }

        if(!q1.empty() && q1.front() % 2 != 0){
            q1.push(q1.front());
            q1.pop();
        }


    }

    return count;
}

int main(){
    int n;
    cout<<"Enter n: ";
    cin>>n;

    int x;
    cout<<"Enter the element: ";
    cin>>x;

    cout<<TimeTaken(n,x);

    return 0;

}