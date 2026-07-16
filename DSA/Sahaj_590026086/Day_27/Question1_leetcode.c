int compress(char* chars, int charsSize) {
    int i=0,index=0;
    while (i<charsSize) {
        char current=chars[i];
        int count=0;
        while (i<charsSize&&chars[i]==current){
            i++;
            count++;
        }
        chars[index++]=current;
        if (count>1){
            char temp[10];
            int k=0;
            while (count>0) {
                temp[k++]=(count%10)+'0';
                count/=10;
            }
            for (int j=k-1;j>=0;j--){
                chars[index++]=temp[j];
            }
        }
    }
    return index;
}
