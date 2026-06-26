#include <pthread.h>
#include <stdio.h>

typedef struct {
  int val;
  int count;
} group;

typedef struct {
  group *t_arr;
  int *arr;
  int mode; // 1 => increment, 0 => decrement
  int len;
  int *used_len;
} thread_input;

pthread_mutex_t lock = PTHREAD_MUTEX_INITIALIZER;

void *update_arr(void *);

int main() {
  int len1, len2;

  printf("Enter length of arr1: ");
  scanf("%d", &len1);

  printf("Enter length of arr2: ");
  scanf("%d", &len2);

  if (len1 != len2) {
    printf("false\n");
    return 0;
  }

  int arr1[len1], arr2[len2];

  printf("Enter elements of arr1: ");
  for (int i = 0; i < len1; i++)
    scanf("%d", &arr1[i]);

  printf("Enter elements of arr2: ");
  for (int i = 0; i < len2; i++)
    scanf("%d", &arr2[i]);

  group t_arr[len1];
  int used_len = 0;

  pthread_t t1, t2;
  thread_input i1, i2;

  i1 = (thread_input){t_arr, arr1, 1, len1, &used_len};
  i2 = (thread_input){t_arr, arr2, 0, len2, &used_len};

  pthread_create(&t1, NULL, update_arr, &i1);
  pthread_create(&t2, NULL, update_arr, &i2);

  pthread_join(t1, NULL);
  pthread_join(t2, NULL);

  for (int i = 0; i < used_len; i++) {
    if (t_arr[i].count != 0) {
      printf("false\n");
      return 0;
    }
  }

  printf("true\n");

  pthread_mutex_destroy(&lock);

  return 0;
}

void *update_arr(void *a) {
  thread_input *ip = (thread_input *)a;

  for (int i = 0; i < ip->len; i++) {

    pthread_mutex_lock(&lock);

    int pos = -1;

    for (int j = 0; j < *(ip->used_len); j++) {
      if (ip->t_arr[j].val == ip->arr[i]) {
        pos = j;
        break;
      }
    }

    if (pos == -1) {
      pos = *(ip->used_len);

      ip->t_arr[pos].val = ip->arr[i];
      ip->t_arr[pos].count = 0;

      (*(ip->used_len))++;
    }

    if (ip->mode)
      ip->t_arr[pos].count++;
    else
      ip->t_arr[pos].count--;

    pthread_mutex_unlock(&lock);
  }

  return NULL;
}
