#include <stdlib.h>

typedef struct Node
{
    struct Node *child[2];
} Node;

Node* createNode()
{
    Node *node = malloc(sizeof(Node));
    node->child[0] = NULL;
    node->child[1] = NULL;
    return node;
}

void insert(Node *root, int num)
{
    Node *current = root;

    for (int bit = 30; bit >= 0; bit--)
    {
        int b = (num >> bit) & 1;

        if (current->child[b] == NULL)
            current->child[b] = createNode();

        current = current->child[b];
    }
}

int getMaxXOR(Node *root, int num)
{
    Node *current = root;
    int result = 0;

    for (int bit = 30; bit >= 0; bit--)
    {
        int b = (num >> bit) & 1;
        int opposite = 1 - b;

        if (current->child[opposite] != NULL)
        {
            result |= (1 << bit);
            current = current->child[opposite];
        }
        else
        {
            current = current->child[b];
        }
    }

    return result;
}

int findMaximumXOR(int *nums, int numsSize)
{
    Node *root = createNode();
    int answer = 0;

    insert(root, nums[0]);

    for (int i = 1; i < numsSize; i++)
    {
        int current = getMaxXOR(root, nums[i]);

        if (current > answer)
            answer = current;

        insert(root, nums[i]);
    }

    return answer;
}