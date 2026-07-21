//Need to simulate the ticket counter queue

#include <iostream>
#include <queue>
using namespace std;

int main()
{
    int n = 4;
    int k = 3;

    queue<int> q;

    for (int i = 1; i <= n; i++)
    {
        q.push(i);
    }

    int minute = 0;

    while (!q.empty())
    {
        int person = q.front();
        q.pop();

        minute++;

        if (person == k)
        {
            cout << minute;
            break;
        }

        // after serving, move the new front to the back if it is odd
        if (!q.empty() && q.front() % 2 == 1)
        {
            int frontPerson = q.front();
            q.pop();
            q.push(frontPerson);
        }
    }

    return 0;
}