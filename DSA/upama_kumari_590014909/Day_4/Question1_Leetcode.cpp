#include <iostream>
#include <vector>
using namespace std;

vector<vector<int>> transpose(vector<vector<int>>& matrix)
{
    int m = matrix.size();
    int n = matrix[0].size();

    vector<vector<int>> result(n, vector<int>(m));

    for(int i = 0; i < m; i++)
    {
        for(int j = 0; j < n; j++)
        {
            result[j][i] = matrix[i][j];
        }
    }
    return result;
}
int main()
{
    vector<vector<int>> matrix = {
        {1,2,3},
        {2,3,4},
        {3,4,5}
    };

    vector<vector<int>> ans = transpose(matrix);

    for(int i = 0; i < ans.size(); i++)
    {
        for(int j = 0; j < ans[i].size(); j++)
        {
            cout << ans[i][j] << " ";
        }
        cout << endl;
    }

    return 0;
}