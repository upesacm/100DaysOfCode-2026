int* numberOfLines(int* widths, int widthsSize, char * s, int* returnSize){
    int *arr=malloc(sizeof(int)*2);
    int line=1,current=0;
    for(int i=0;s[i]!='\0';i++){
        int w=widths[s[i]-'a'];
        if(current+w>100){
            line++;
            current=w;
        }
        else
        current=current+w;
    }
    arr[0]=line;
    arr[1]=current;
    *returnSize=2;
    return arr;
}
