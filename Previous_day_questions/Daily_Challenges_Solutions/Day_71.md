<h2 align="center">Week 11 Day 71 (24/08/2026)</h2>

## 1. Find the Town Judge (LeetCode #997)
### Solution
```cpp
#include <bits/stdc++.h>
using namespace std;

int findJudge(int n, vector<pair<int,int>>& trust) {
    vector<int> score(n + 1, 0);
    for (auto& [a, b] : trust) {
        score[a]--;
        score[b]++;
    }
    for (int i = 1; i <= n; i++) {
        if (score[i] == n - 1) return i;
    }
    return -1;
}

int main() {
    int n, m;
    cin >> n >> m;
    vector<pair<int,int>> trust(m);
    for (int i = 0; i < m; i++) {
        cin >> trust[i].first >> trust[i].second;
    }
    cout << findJudge(n, trust) << "\n";
    return 0;
}
```
* Time: O(n + m) — one pass over the trust list to update scores, then one pass over the people to find the judge.
* Space: O(n) for the score array.

Each trust relationship `a -> b` means `a` gains an outgoing trust (so its score decreases by one) and `b` gains an incoming trust (so its score increases by one). A valid town judge is trusted by everyone else and trusts nobody, so their net score is exactly `n - 1`, since they receive `n - 1` incoming trusts and contribute zero outgoing ones. Scanning the score array for a value equal to `n - 1` after processing all relationships correctly identifies the unique judge, or reports -1 if no such person exists.

---

## 2. Grid Encryption
### Solution
```cpp
#include <bits/stdc++.h>
using namespace std;

string encryptGrid(const string& s) {
    string text;
    for (char c : s) if (c != ' ') text += c;
    int L = text.size();
    if (L == 0) return "";

    int cols = (int)ceil(sqrt((double)L));
    int rows = (int)ceil((double)L / cols);

    vector<string> grid(rows, string(cols, '\0'));
    int idx = 0;
    for (int r = 0; r < rows && idx < L; r++)
        for (int c = 0; c < cols && idx < L; c++)
            grid[r][c] = text[idx++];

    string result;
    for (int c = 0; c < cols; c++) {
        string col;
        for (int r = 0; r < rows; r++)
            if (grid[r][c] != '\0') col += grid[r][c];
        if (!col.empty()) {
            if (!result.empty()) result += ' ';
            result += col;
        }
    }
    return result;
}

int main() {
    string line;
    getline(cin, line);
    cout << encryptGrid(line) << "\n";
    return 0;
}
```
* Time: O(L) — computing the grid dimensions is O(1), and both filling the grid row by row and reading it column by column visit each of the `rows * cols` cells once, which is O(L) since `cols = ceil(sqrt(L))` keeps the grid size close to `L`.
* Space: O(L) for the grid and the output string.

The dimensions are fixed by taking `columns` as the smallest integer whose square is at least `L`, which keeps the grid as close to square as possible, and then setting `rows` to just enough rows to fit all `L` characters into that many columns. Filling the grid in row-major order preserves the original left-to-right, top-to-bottom reading order of the text, so the last row may end up only partially filled while every earlier row is complete. Reading the grid column by column — skipping the empty cells that occur only in the trailing part of the last row — scrambles the character order in a reversible, deterministic way, and joining each column's characters with a space produces the final encoded message.
