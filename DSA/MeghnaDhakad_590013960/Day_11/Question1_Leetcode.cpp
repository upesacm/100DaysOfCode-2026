class Solution {
public:
    vector<int> numberOfLines(vector<int>& widths, string s) {
        int lines = 1, cur = 0;

        for (char c : s) {
            int w = widths[c - 'a'];

            if (cur + w > 100) {
                lines++;
                cur = w;
            } else {
                cur += w;
            }
        }

        return {lines, cur};
    }
};
