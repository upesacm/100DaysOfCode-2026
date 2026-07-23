#include <iostream>
#include <vector>
#include <queue>
using namespace std;

class Solution {
public:
    int timeRequiredToBuy(vector<int>& tickets, int k) {
        queue<pair<int, int>> q;

        for (int i = 0; i < tickets.size(); i++) {
            q.push({tickets[i], i});
        }

        int time = 0;

        while (!q.empty()) {
            pair<int, int> person = q.front();
            q.pop();
            person.first--;
            time++;

            if (person.second == k && person.first == 0) {
                return time;
            }
            if (person.first > 0) {
                q.push(person);
            }
        }

        return time;
    }
};

