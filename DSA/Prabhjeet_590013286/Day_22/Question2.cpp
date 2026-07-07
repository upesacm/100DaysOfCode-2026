//Need to simulate both players picking the larger card from either end

#include <iostream>
#include <vector>
using namespace std;

int main()
{
    vector<int> cards = {4, 1, 2, 10};

    int left = 0;
    int right = cards.size() - 1;

    int player1 = 0;
    int player2 = 0;

    bool firstTurn = true;

    while (left <= right)
    {
        int pick;

        // always take the larger card from either end
        if (cards[left] >= cards[right])
        {
            pick = cards[left];
            left++;
        }
        else
        {
            pick = cards[right];
            right--;
        }

        // keep switching turns
        if (firstTurn)
        {
            player1 += pick;
        }
        else
        {
            player2 += pick;
        }

        firstTurn = !firstTurn;
    }

    cout << player1 << " " << player2;

    return 0;
}