#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

class Solution {
public:
    int minMeetingRooms(vector<vector<int>>& intervals) {

        if (intervals.empty())
            return 0;

        sort(intervals.begin(), intervals.end());

        priority_queue<int, vector<int>, greater<int>> pq;

        pq.push(intervals[0][1]);

        for (int i = 1; i < intervals.size(); i++) {
            if (intervals[i][0] >= pq.top()) {
                pq.pop();
            }
            pq.push(intervals[i][1]);
        }

        return pq.size();
    }
};

int main() {

    int n;
    cout << "Enter number of meetings: ";
    cin >> n;

    vector<vector<int>> intervals(n, vector<int>(2));

    cout << "Enter start and end time of each meeting:\n";
    for (int i = 0; i < n; i++) {
        cin >> intervals[i][0] >> intervals[i][1];
    }

    Solution obj;

    cout << "Minimum Conference Rooms Required = "
         << obj.minMeetingRooms(intervals);

    return 0;
}