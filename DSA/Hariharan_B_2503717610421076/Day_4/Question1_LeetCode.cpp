class Solution {
public:
    vector<vector<int>> transpose(vector<vector<int>>& matrix) {
        
        int i,j;

        

        int r = matrix.size();
        int c = matrix[0].size();

        vector<vector<int>> m(c,vector<int>(r));

        for(i=0;i<r;i++)
        {
            for(j=0;j<c;j++)
            {
                m[j][i]=matrix[i][j];
            }
        }
        
        return m;
    }
    
};
