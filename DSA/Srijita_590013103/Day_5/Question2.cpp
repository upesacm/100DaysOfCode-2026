#include <vector>
#include <unordered_map>
using namespace std;

class Solution {
public:
    bool checkEqual(vector<int>& a, vector<int>& b) {
    unordered_map<int,int> mp;

    for(int x : a)
        mp[x]++;

    for(int x : b)
        mp[x]--;

    for(auto p : mp)
        if(p.second != 0)
            return false;

    return true;

    }
};