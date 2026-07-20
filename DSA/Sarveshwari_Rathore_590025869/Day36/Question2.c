#include <stdio.h>
int main(){
    int n, k;
    scanf("%d %d", &n, &k);
    int q[1000];
    int bottom = 0, top = -1;
    for (int i = 1;i <= n;i++) {
        q[++top] = i;
    }
    int minute = 0;
    while (bottom <= top) {
        int served = q[bottom++];
        minute++;
        if (served == k) {
            printf("%d\n", minute);
            return 0;
        }
        if (bottom <= top) {
            if (q[bottom] % 2 != 0) {
                int temp = q[bottom++];
                q[++top] = temp;
            }
        }
    }
    return 0;
}