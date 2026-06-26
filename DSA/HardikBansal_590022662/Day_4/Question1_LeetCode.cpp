class Solution {
public:
    vector<vector<int>> transpose(vector<vector<int>>& matrix) {
        int rows=matrix.size(),col=matrix[0].size();
        vector<vector<int>> result(col,vector<int>(rows));
        for(int i=0;i<col;i++)
        {
            for(int j=0;j<rows;j++)
            {
                result[i][j]=matrix[j][i];
            }
        }

        return result;
    }
};