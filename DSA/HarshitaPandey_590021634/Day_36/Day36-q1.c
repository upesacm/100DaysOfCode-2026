/* Q1: Simulate a ticket counter queue where, after each serve, the new front person 
moves to the back if their number is odd, and find the minute at which person k gets served.

Example:
Input: n = 4, k = 3; Output: 4.      */


#include <stdio.h>

#include <stdio.h>
#include <stdlib.h>

int main() 
{
    int n, k;
    
   
    printf("Enter total no. of people (n) and target person (k): ");
    
    if (scanf("%d %d", &n, &k) != 2) 
    {
        printf("Invalid input.\n");
        return 1;
    }
    
    
    if (k < 1 || k > n) 
    {
        printf("Person k must be between 1 and %d.\n", n);
        return 1;
    }

    int *queue = (int *)malloc((2 * n + 1) * sizeof(int));
    if (queue == NULL) 
    {
        printf("Memory allocation failed.\n");
        return 1;
    }

    
    for (int i = 0; i < n; i++) 
    {
        queue[i] = i + 1;
    }

    int front = 0;
    int rear = n;
    int minute = 0;

    while (front < rear) 
    {
        
        int served = queue[front++];
        minute++;

       
        if (served == k) 
        {
            printf("Person %d gets served at minute: %d\n", k, minute);
            free(queue);
            return 0;
        }

        
        if (front < rear) 
        {
            int new_front = queue[front];
            
            if (new_front % 2 != 0) 
            {
                queue[rear++] = queue[front++];
            }
        }
    }

    free(queue);
    return 0;
}
