#include <stdio.h>

void game(int* arr, int arrSize) {
    int i = 0;
    int j = arrSize - 1;
    
    int scores[2] = {0, 0};
    int turn = 0;

    while (i <= j) {
        if (arr[i] >= arr[j]) {
            scores[turn] += arr[i];
            i++;
        } 
        else {
            scores[turn] += arr[j];
            j--;
        }
        turn = !turn; 
    }

    printf("Player 1 Score: %d\nPlayer 2 Score: %d", scores[0], scores[1]);
}

int main() {
    int n;
    printf("Enter the size of the array (or the number of cards that the game starts with): ");
    scanf("%d", &n);

    int arr[n];
    printf("Enter the elements of the array (Values of the cards): ");
    for(int i=0; i<n; i++) {
        scanf("%d", &arr[i]);}
    
    game(arr, n);
    return 0;
}