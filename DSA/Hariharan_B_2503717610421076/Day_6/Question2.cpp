#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    int n, m;

    cout << "Enter size of first array : ";
    cin >> n;

    vector<int> a(n);

    cout << "Enter elements of first array : ";
    for(int i = 0; i < n; i++)
    {
        cin >> a[i];
    }

    cout << "Enter size of second array : ";
    cin >> m;

    vector<int> b(m);

    cout << "Enter elements of second array : ";
    for(int i = 0; i < m; i++)
    {
        cin >> b[i];
    }

    vector<int> c;

    // Merge both vectors
    for(int i = 0; i < n; i++)
    {
        c.push_back(a[i]);
    }

    for(int i = 0; i < m; i++)
    {
        c.push_back(b[i]);
    }

    // Sort the merged vector
    sort(c.begin(), c.end());

    // Remove duplicates
    for(int i = 0; i < c.size() - 1; i++)
    {
        if(c[i] == c[i + 1])
        {
            c.erase(c.begin() + i);
            i--;
        }
    }

    // Display union
    cout << "\nUnion Array : ";

    for(int i = 0; i < c.size(); i++)
    {
        cout << c[i] << " ";
    }

    return 0;
}
