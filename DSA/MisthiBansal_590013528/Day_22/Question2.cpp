/*Two players are given a row of cards, where each card contains a distinct number. Players
take turns picking either the leftmost or rightmost card from the row. The first player starts
the game. Both players always choose the card with the larger value available at either end.
The game ends when all cards are picked. Return the final scores of both players.*/

#include <bits/stdc++.h>
using namespace std;

int main()
{
    cout << "enter the no. of elements in array" << endl;
    int n;
    cin >> n;
    vector<int> nums(n);
    cout << "enter the elements of arrays" << endl;
    for (int i = 0; i < n; i++)
    {
        cin >> nums[i];
    }

    int p1 = 0;
    int p2 = 0;
    bool player1turn = true;
    while (!nums.empty())
    {

        if (player1turn)
        {
            if (nums.front() > nums.back())
            {
                p1 = p1 + nums.front();
                nums.erase(nums.begin());
            }
            else
                p1 = p1 + nums.back();
            nums.pop_back();
        }
        else
        {
            if (nums.front() > nums.back())
            {
                p2 = p2 + nums.front();
                nums.erase(nums.begin());
            }
            else
            {
                p2 = p2 + nums.back();
                nums.pop_back();
            }
        }
        player1turn = !player1turn;
    }
    cout << " Player 1" << p1 << endl;
    cout << " Player 2" << p2 << endl;
return 0;
}