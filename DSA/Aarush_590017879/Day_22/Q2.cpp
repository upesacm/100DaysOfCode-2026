#include <iostream>
#include <vector>
using namespace std;

int main() {
    int n;
    cin >> n;

    vector<int> cards(n);

    for (int i = 0; i < n; i++) {
        cin >> cards[i];
    }

    int left = 0, right = n - 1;
    int player1 = 0, player2 = 0;
    bool turn = true;

    while (left <= right) {
        int chosen;

        if (cards[left] >= cards[right]) {
            chosen = cards[left];
            left++;
        } else {
            chosen = cards[right];
            right--;
        }

        if (turn)
            player1 += chosen;
        else
            player2 += chosen;

        turn = !turn;
    }

    cout << player1 << " " << player2 << endl;

    return 0;
}