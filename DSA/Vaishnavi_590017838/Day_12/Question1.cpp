#include <iostream>
#include <vector>
#include <string>
using namespace std;
class Solution {
public:
    vector<int> numberOfLines(vector<int>& widths, string s) {
        int lines = 1;
        int currentWidth = 0;
        for(int i = 0; i < s.length(); i++) {
            int letterWidth = widths[s[i] - 'a'];
            if(currentWidth + letterWidth > 100) {
                lines++;
                currentWidth = letterWidth;
            }
            else {
                currentWidth += letterWidth;
            }
        }
        return {lines, currentWidth};
    }
};
int main() {
    vector<int> widths(26,10);
    string s = "abcdefghijklmnopqrstuvwxyz";
    Solution obj;
    vector<int> ans = obj.numberOfLines(widths,s);
    cout << ans[0] << " " << ans[1];

    return 0;
}
