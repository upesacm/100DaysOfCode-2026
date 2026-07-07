#include <iostream>
#include <vector>
using namespace std;

int main() {
    vector<int> cards = {4, 1, 2, 10};

    int left = 0, right = cards.size() - 1;
    int player1 = 0, player2 = 0;
    bool turn = true; // true -> Player 1, false -> Player 2

    while (left <= right) {
        int picked;

        if (cards[left] >= cards[right]) {
            picked = cards[left];
            left++;
        } else {
            picked = cards[right];
            right--;
        }

        if (turn)
            player1 += picked;
        else
            player2 += picked;

        turn = !turn;
    }

    cout << player1 << " " << player2 << endl;

    return 0;
}
