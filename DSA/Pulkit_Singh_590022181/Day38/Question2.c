#include <stdio.h>

#define MAX 100

void reconstructDeck(int n) {

    int deck[MAX];
    int size = 0;

    for (int card = n; card >= 1; card--) {

        // Move last element to front
        if (size > 0) {
            int last = deck[size - 1];

            for (int i = size - 1; i > 0; i--)
                deck[i] = deck[i - 1];

            deck[0] = last;
        }

        // Insert current card at front
        for (int i = size; i > 0; i--)
            deck[i] = deck[i - 1];

        deck[0] = card;
        size++;
    }

    printf("Deck: [");
    for (int i = 0; i < size; i++) {
        printf("%d", deck[i]);
        if (i != size - 1)
            printf(", ");
    }
    printf("]\n");
}

int main() {

    int n = 4;

    reconstructDeck(n);

    return 0;
}