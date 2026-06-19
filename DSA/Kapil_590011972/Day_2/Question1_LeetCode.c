// Removal of value (in-place)
// retrun num of elements remaining

// Constraints: 0 ≤ nums.length ≤ 100, 0 ≤ val ≤ 100

#include <pthread.h>
#include <stdio.h>
#include <unistd.h>

typedef struct {
  int *arr;
  long long start;
  long long stop;
  int val;
} chunk;

int get_core_count() { return (int)sysconf(_SC_NPROCESSORS_ONLN); }

void remove_val(int *arr, int len, int val);
void *remove_val_chunk(void *);
int collapse_array(int *arr, int invalid, int len);

int main() {
  // taking input
  int len, val, invalid = -1;
  printf("Enter length of aray: ");
  scanf("%d", &len);
  int arr[len];
  printf("Enter elements: ");
  for (int i = 0; i < len; i++) {
    scanf("%d", &arr[i]);
  }

  printf("Enter the value to remove: ");
  scanf("%d", &val);
  remove_val(arr, len, val);
  int k = collapse_array(arr, invalid, len);
  printf("Number of remaining elements: %d", k);
}

void remove_val(int *arr, int len, int val) {
  long long start = 0, stop = 0;
  int num_thread = 0;

  // setting number of threads
  if (len < 10000)
    num_thread = 1;
  else
    num_thread = get_core_count();

  // insitialising chunk, starting threads
  pthread_t threads[num_thread];
  chunk thread_chunks[num_thread];
  for (int i = 0; i < num_thread; i++) {
    start = stop;
    stop = (i == num_thread - 1) ? (len) : (stop + len / num_thread);
    thread_chunks[i] = (chunk){arr, start, stop, val};

    pthread_create(&threads[i], NULL, remove_val_chunk,
                   (void *)&thread_chunks[i]);
  }

  // joining threads
  for (int i = 0; i < num_thread; i++) {
    pthread_join(threads[i], NULL);
  }
}

void *remove_val_chunk(void *c) {
  chunk *chk = (chunk *)c;
  for (int i = chk->start; i < chk->stop; i++) {
    if (chk->arr[i] == chk->val)
      chk->arr[i] = -1;
  }
  return NULL;
}

int collapse_array(int *arr, int invalid, int len) {
  int top = 0;
  for (int i = 0; i < len; i++) {
    if (arr[i] == invalid) {
      ;
    } else {
      arr[top] = arr[i];
      top++;
    }
  }
  return top;
}
