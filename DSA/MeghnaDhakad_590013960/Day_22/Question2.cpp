#include <iostream>
#include <vector>
using namespace std;

int main() {

    vector<int> cards = {4,1,2,10};

    int left = 0;
    int right = cards.size() - 1;

    int player1 = 0;
    int player2 = 0;

    bool turn = true;

    while (left <= right) {

        int pick;

        if (cards[left] >= cards[right]) {
            pick = cards[left++];
        } else {
            pick = cards[right--];
        }

        if (turn)
            player1 += pick;
        else
            player2 += pick;

        turn = !turn;
    }

    cout << player1 << " " << player2;

    return 0;
}