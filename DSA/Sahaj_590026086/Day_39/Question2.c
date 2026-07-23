#include <stdio.h>
#include <stdlib.h>

int cmp(const void* a, const void* b) {
    return (*(int*)a - *(int*)b);
}
int main() {
    int n;
    printf("Enter the number of elements you want to enter:");
    scanf("%d", &n);
    int start[n], end[n];

    for (int i=0;i<n;i++){
        printf("Enter intervals separeted by space:");
        scanf("%d %d", &start[i], &end[i]);
    }

    qsort(start, n, sizeof(int), cmp);
    qsort(end, n, sizeof(int), cmp);

    int i=0,j=0;
    int rooms=0,maxrooms=0;
    while (i<n){
        if (start[i]<end[j]){
            rooms++;
            if (rooms>maxrooms)
                maxrooms=rooms;
            i++;
        }else{
            rooms--;
            j++;
        }
    }
    printf("%d\n", maxrooms);
    return 0;
}
