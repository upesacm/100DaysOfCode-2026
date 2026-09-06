class Solution {
public:
    int countStudents(vector<int>& students, vector<int>& sandwiches) {

        int count[2] = {0};

        for (int s : students)
            count[s]++;

        for (int sandwich : sandwiches) {

            if (count[sandwich] == 0)
                break;

            count[sandwich]--;
        }

        return count[0] + count[1];
    }
};