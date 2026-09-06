// question- 2073
// Time Needed to Buy Tickets
class Solution {
public:
    int timeRequiredToBuy(vector<int>& tickets, int k) {
        queue<int>q;
        int time = 0;
        for(int i = 0; i < tickets.size() ; i++){
            q.push(i);
        }
        while(true){
            int person = q.front();
            q.pop();
            tickets[person]--;
            time ++ ;
            if(person == k && tickets[person] == 0)
            return time;

            if(tickets[person] > 0)
             q.push(person);        
        }
        return time;
    }
};
          