class Solution {
public:
    vector<int> numberOfLines(vector<int>& widths, string s) {
        int lines = 1;
        int current_width = 0;
        
        for (char c : s) {
            int char_width = widths[c - 'a']; 
            
            if (current_width + char_width > 100) {
                lines++;                  
                current_width = char_width; 
            } else {
                current_width += char_width; 
            }
        }
        
        return {lines, current_width};



    }
};