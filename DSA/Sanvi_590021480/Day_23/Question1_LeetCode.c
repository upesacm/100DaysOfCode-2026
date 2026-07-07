int cmp(const void *a, const void *b) {
    return (*(int*)a - *(int*)b);
}

int findContentChildren(int* g, int gSize, int* s, int sSize) {
    qsort(g, gSize, sizeof(int), cmp);
    qsort(s, sSize, sizeof(int), cmp);

    int first=0,second=0;
    int count=0;
    while(first<gSize && second<sSize){
        if(g[first]<=s[second]){
            count++;
            first++;
        }
            second++;                                          
    }
    return count;
}
