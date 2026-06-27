#include <iostream>
#include <vector>
#include <string>
using namespace std;

vector<int> numberOfLines(vector<int>& widths, string s) {
    int lines = 1;
    int currentWidth = 0;

    for (char c : s) {
        int w = widths[c - 'a'];

        if (currentWidth + w > 100) {
            lines++;
            currentWidth = w; 
        } else {
            currentWidth += w;
        }
    }

    return {lines, currentWidth};
}

int main() {
    vector<int> widths1(26, 10);
    string s1 = "abcdefghijklmnopqrstuvwxyz";
    vector<int> result1 = numberOfLines(widths1, s1);
    cout << result1[0] << " " << result1[1]<< endl;

    vector<int> widths2(26, 10);
    string s2 = "bbbcccdddaaa";
    vector<int> result2 = numberOfLines(widths2, s2);
    cout<< result2[0] <<" " << result2[1] << endl;

    return 0;
}