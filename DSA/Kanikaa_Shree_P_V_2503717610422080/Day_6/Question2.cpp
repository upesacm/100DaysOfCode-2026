#include <iostream>
using namespace std;

int main() {
    int n, m;
    cin >> n;
    int a[n];

    for(int i = 0; i < n; i++)
        cin >> a[i];

    cin >> m;
    int b[m];

    for(int i = 0; i < m; i++)
        cin >> b[i];

    int i = 0, j = 0;
    int last = -1;

    while(i < n && j < m) {
        int x;

        if(a[i] < b[j])
            x = a[i++];
        else if(a[i] > b[j])
            x = b[j++];
        else {
            x = a[i];
            i++;
            j++;
        }

        if(x != last) {
            cout << x << " ";
            last = x;
        }
    }

    while(i < n) {
        if(a[i] != last) {
            cout << a[i] << " ";
            last = a[i];
        }
        i++;
    }

    while(j < m) {
        if(b[j] != last) {
            cout << b[j] << " ";
            last = b[j];
        }
        j++;
    }

    return 0;
}