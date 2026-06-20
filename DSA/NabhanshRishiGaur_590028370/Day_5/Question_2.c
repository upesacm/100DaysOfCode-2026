#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include "uthash.h"

typedef struct {
    int key;
    int count;
    UT_hash_handle hh;
} HashNode;

bool checkEqual(int a[], int b[], int n) {
    HashNode *map = NULL, *node;

    for (int i = 0; i < n; i++) {
        HASH_FIND_INT(map, &a[i], node);

        if (node == NULL) {
            node = malloc(sizeof(HashNode));
            node->key = a[i];
            node->count = 1;
            HASH_ADD_INT(map, key, node);
        } else {
            node->count++;
        }
    }

    for (int i = 0; i < n; i++) {
        HASH_FIND_INT(map, &b[i], node);

        if (node == NULL || node->count == 0)
            return false;

        node->count--;
    }

    for (node = map; node != NULL; node = node->hh.next) {
        if (node->count != 0)
            return false;
    }

    return true;
}
