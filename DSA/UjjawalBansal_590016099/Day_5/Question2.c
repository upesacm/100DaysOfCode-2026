#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#define SIZE 100047
typedef struct {
    int val;
    int c;
    bool occ;
} h;

int hash(int val) {
    int ans = val%SIZE;
    if (ans<0) ans+= SIZE;
    return ans;
}

void update(h* table, int val, int a) {
    int i = hash(val);
    while(table[i].occ && table[i].val!=val) {
        i = (i+1)%SIZE;
    }

    if(!table[i].occ) {
        table[i].val = val;
        table[i].c = -0;
        table[i].occ = true;
    }
    
    table[i].c += a;
}

bool equality(int* arr1, int* arr2, int n) {
    h* table = (h*)calloc(SIZE, sizeof(h));
    for(int i=0; i<n; i++) {
        update(table, arr1[i], 1);
        update(table, arr2[i], -1);
    }
    
    for(int i=0; i<SIZE; i++) {
        if(table[i].occ && table[i].c!=0) {
            free(table);
            return false;
        }
    }
    free(table);
    return true;
}

void main() {
    int n;
    printf("Enter the number of elements in both arrays: ");
    scanf("%d", &n);

    int a[n], b[n];
    printf("Enter %d elements for first array: ", n);
    for(int i=0; i<n; i++) {
        scanf("%d", &a[i]);
    }
    printf("Enter %d elements for second array: ", n);
    for(int i=0; i<n; i++) {
        scanf("%d", &b[i]);
    }
    printf("%s\n", equality(a, b, n) ? "true" : "false");
}