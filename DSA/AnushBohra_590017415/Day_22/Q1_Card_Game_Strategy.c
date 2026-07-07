#include <stdio.h>
#include <stdbool.h>

void card_game_strategy(int cards[], int size, int *score1, int *score2) {
    int left = 0;
    int right = size - 1;
    
    *score1 = 0;
    *score2 = 0;
    bool player1_turn = true;
    
    while (left <= right) {
        int chosen_card;
        
        // If only one card is left, the current player takes it
        if (left == right) {
            chosen_card = cards[left];
            left++;
        }
        // Otherwise, pick the larger card from either end
        else if (cards[left] >= cards[right]) {
            chosen_card = cards[left];
            left++;
        } else {
            chosen_card = cards[right];
            right--;
        }
        
        // Assign score to the respective player
        if (player1_turn) {
            *score1 += chosen_card;
        } else {
            *score2 += chosen_card;
        }
        
        // Alternate turns
        player1_turn = !player1_turn;
    }
}

int main() {
    // Test case from the challenge example
    int example_cards[] = {4, 1, 2, 10};
    int size = sizeof(example_cards) / sizeof(example_cards[0]);
    
    int p1_score = 0;
    int p2_score = 0;
    
    printf("Running example with cards: ");
    for (int i = 0; i < size; i++) {
        printf("%d ", example_cards[i]);
    }
    printf("\n");
    
    card_game_strategy(example_cards, size, &p1_score, &p2_score);
    
    // Output format matching the example: "12 5"
    printf("Output: %d %d\n", p1_score, p2_score);
    
    return 0;
}