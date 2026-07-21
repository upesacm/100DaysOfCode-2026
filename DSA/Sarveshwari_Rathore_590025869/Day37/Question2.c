#include <stdio.h>
int main() {
    int n;
    scanf("%d", &n);
    int priorities[n];
    for (int i = 0;i < n;i++) {
        scanf("%d",&priorities[i]);
    }
    int location;
    scanf("%d",&location);
    int bottom = 0,top = n - 1;
    int printed = 0;
    while(bottom <= top){
        int max = priorities[bottom];
        for(int i = bottom + 1; i <= top; i++){
            if (priorities[i] > max)
                max = priorities[i];
        }
        if (priorities[bottom] == max){
            printed++;
            if (bottom == location) {
                printf("%d\n", printed);
                return 0;
            }
            bottom++;
        } else{
            int temp = priorities[bottom];
            for(int i = bottom; i < top; i++){
                priorities[i] = priorities[i + 1];
            }
            priorities[top] = temp;
            if(location == bottom){
                location = top;
            } else{
                location--;
            }
        }
    }
    return 0;
}