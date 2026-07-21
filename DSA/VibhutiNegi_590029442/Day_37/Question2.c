#include <stdio.h>
#define MAX 100000
typedef struct
{
    int priority;
    int index;
} Document;
int printTime(int priorities[], int n, int location)
{
    Document q[MAX];
    int count[10] = {0};
    int front = 0, rear = 0;
    int time = 0;
    for(int i = 0; i < n; i++)
    {
        q[rear].priority = priorities[i];
        q[rear].index = i;
        count[priorities[i]]++;
        rear++;
    }
    int highest = 9;
    while(front < rear)
    {
        while(highest > 0 && count[highest] == 0)
            highest--;
        Document cur = q[front++];
        if(cur.priority < highest)
        {
            q[rear++] = cur;
        }
        else
        {
            time++;
            count[cur.priority]--;
            if(cur.index == location)
                return time;
        }
    }
    return time;
}
int main()
{
    int n, location;
    int priorities[MAX];
    printf("Enter number of documents: ");
    scanf("%d", &n);
    printf("Enter priorities:\n");
    for(int i = 0; i < n; i++)
    {
        scanf("%d", &priorities[i]);
    }
    printf("Enter location: ");
    scanf("%d", &location);
    printf("Time required = %d\n", printTime(priorities, n, location));
    return 0;
}