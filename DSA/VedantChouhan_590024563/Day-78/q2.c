#include <stdio.h>
#include <stdlib.h>

#define MAX_BITS 31
#define MAX_NODES 3100000

typedef struct {
    int child[2];
} TrieNode;

TrieNode trie[MAX_NODES];
int nodeCount = 1;

/* Insert a number into the binary Trie */
void insert(int num) {
    int node = 0;

    for (int bit = MAX_BITS - 1; bit >= 0; bit--) {
        int b = (num >> bit) & 1;

        if (trie[node].child[b] == 0) {
            trie[node].child[b] = nodeCount++;
        }

        node = trie[node].child[b];
    }
}

/* Find the maximum XOR possible with num */
int getMaxXOR(int num) {
    int node = 0;
    int result = 0;

    for (int bit = MAX_BITS - 1; bit >= 0; bit--) {
        int b = (num >> bit) & 1;
        int opposite = 1 - b;

        if (trie[node].child[opposite] != 0) {
            result |= (1 << bit);
            node = trie[node].child[opposite];
        } else {
            node = trie[node].child[b];
        }
    }

    return result;
}

int main() {
    int n;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    int nums[n];

    printf("Enter elements: ");

    for (int i = 0; i < n; i++) {
        scanf("%d", &nums[i]);
    }

    if (n < 2) {
        printf("Maximum XOR Pair: 0\n");
        return 0;
    }

    int answer = 0;

    /*
       Insert the first number.
       For every next number, find the best XOR
       with numbers already inserted.
    */
    insert(nums[0]);

    for (int i = 1; i < n; i++) {

        int current = getMaxXOR(nums[i]);

        if (current > answer)
            answer = current;

        insert(nums[i]);
    }

    printf("Maximum XOR Pair: %d\n", answer);

    return 0;
}