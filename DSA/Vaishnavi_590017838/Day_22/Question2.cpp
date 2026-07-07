#include <iostream>
#include <vector>
using namespace std;

int main() {
    int n;
    cout << "Enter the number of cards: ";
    cin >> n;
    vector<int> cards(n);
    cout << "Enter the card values: ";
    for(int i = 0; i < n; i++)
        cin >> cards[i];
    int left = 0;
    int right = n - 1;
    int player1 = 0;
    int player2 = 0;
    bool firstTurn = true;
    while(left <= right) {
        int pickedCard;
        if(cards[left] >= cards[right]) {
            pickedCard = cards[left];
            left++;
        }
        else {
            pickedCard = cards[right];
            right--;
        }
        if(firstTurn)
            player1 += pickedCard;
        else
            player2 += pickedCard;
        firstTurn = !firstTurn;
    }
    cout << "Player 1 Score: " << player1 << endl;
    cout << "Player 2 Score: " << player2 << endl;
    return 0;
}
