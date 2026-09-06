#include <bits/stdc++.h>
using namespace std;

int minMeetingRooms(vector<vector<int>>& intervals) {

    if(intervals.empty())
        return 0;

    // Sort by start time
    sort(intervals.begin(), intervals.end());

    // Min heap storing ending times
    priority_queue<int, vector<int>, greater<int>> pq;

    pq.push(intervals[0][1]);

    for(int i = 1; i < intervals.size(); i++) {

        // Reuse a room
        if(pq.top() <= intervals[i][0])
            pq.pop();

        pq.push(intervals[i][1]);
    }

    return pq.size();
}

int main() {

    vector<vector<int>> intervals = {
        {0,30},
        {5,10},
        {15,20}
    };

    cout << minMeetingRooms(intervals);

    return 0;
}