int cmp(const void* a, const void* b);  
int findContentChildren(int* g, int gSize, int* s, int sSize) {
    qsort(g, gSize, sizeof(int), cmp);
    qsort(s, sSize, sizeof(int), cmp);
    int child = 0;
    int cookie = 0;
    int count = 0;
    while (child < gSize && cookie < sSize) {
        if (s[cookie] >= g[child]) {
            count++;
            child++;
        }
        cookie++;
    }
    return count;
}
int cmp(const void* a, const void* b) {
    return (*(int*)a - *(int*)b);
}