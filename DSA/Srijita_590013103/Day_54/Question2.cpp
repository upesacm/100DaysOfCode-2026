class Solution {
public:
    string winner(vector<string>& goals) {

        unordered_map<string, int> freq;

        string win = "";
        int maxGoals = 0;

        for (string team : goals) {

            freq[team]++;

            if (freq[team] > maxGoals) {

                maxGoals = freq[team];
                win = team;
            }
        }

        return win;
    }
};