<h2 align="center">Week 4 Day 22 (06/07/2026)</h2>

## 1. Move Zeroes (LeetCode #283)

### Solution

```c
void moveZeroes(int* nums, int numsSize)
{
    int j = 0; // Position to place the next non-zero element
    // Traverse the array
    for (int i = 0; i < numsSize; i++)
    {
        // If the current element is non-zero
        if (nums[i] != 0)
        {
            // Swap the current element with the element at index j
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            // Move j to the next position
            j++;
        }
    }
}
```

---

## 2. Card Picking Game

### Solution

```c
#include <stdio.h>
int main()
{
    int n;
    // Input number of cards
    scanf("%d", &n);
    int cards[n];
    // Input card values
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &cards[i]);
    }
    int left = 0;
    int right = n - 1;
    int player1 = 0;
    int player2 = 0;
    int turn = 0; // 0 -> Player 1, 1 -> Player 2
    // Continue until all cards are picked
    while (left <= right)
    {
        int picked;
        // Pick the larger value from either end
        if (cards[left] > cards[right])
        {
            picked = cards[left];
            left++;
        }
        else
        {
            picked = cards[right];
            right--;
        }
        // Add picked card to the current player's score
        if (turn == 0)
        {
            player1 += picked;
            turn = 1;
        }
        else
        {
            player2 += picked;
            turn = 0;
        }
    }
    // Print final scores
    printf("%d %d\n", player1, player2);
    return 0;
}
```
