#include <stdio.h>
#include <stdlib.h>

typedef struct TrieNode {
    struct TrieNode *child[2];
} TrieNode;

TrieNode* createNode() {
    TrieNode *node = (TrieNode*)malloc(sizeof(TrieNode));
    node->child[0] = node->child[1] = NULL;
    return node;
}

void insert(TrieNode *root, int num) {
    TrieNode *cur = root;
    for (int i = 30; i >= 0; i--) {
        int bit = (num >> i) & 1;
        if (!cur->child[bit])
            cur->child[bit] = createNode();
        cur = cur->child[bit];
    }
}

int getMaxXor(TrieNode *root, int num) {
    TrieNode *cur = root;
    int result = 0;

    for (int i = 30; i >= 0; i--) {
        int bit = (num >> i) & 1;
        int opposite = bit ^ 1;

        if (cur->child[opposite]) {
            result |= (1 << i);
            cur = cur->child[opposite];
        } else {
            cur = cur->child[bit];
        }
    }

    return result;
}

int maximumXOR(int* nums, int numsSize) {
    if (numsSize < 2)
        return 0;

    TrieNode *root = createNode();
    int ans = 0;

    insert(root, nums[0]);

    for (int i = 1; i < numsSize; i++) {
        int current = getMaxXor(root, nums[i]);
        if (current > ans)
            ans = current;
        insert(root, nums[i]);
    }

    return ans;
}