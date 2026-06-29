char* mostCommonWord(char* paragraph, char** banned, int bannedSize) {
    int freq[1000]={0};
    char words[1000][100];
    int count=0;
    int i=0;
    while(paragraph[i]){
        while(paragraph[i]&&!isalpha(paragraph[i]))
            i++;
        int j=0;
        char temp[100];
        while(paragraph[i]&&isalpha(paragraph[i])){
            temp[j++]=tolower(paragraph[i++]);
        }
        temp[j]='\0';
        if(j==0) 
            continue;
        int bannedFlag=0;
        for(int b=0;b<bannedSize;b++){
            if(strcmp(temp,banned[b])==0){
                bannedFlag=1;
                break;
            }
        }
        if(bannedFlag) 
            continue;
        int found=-1;
        for(int k=0;k<count;k++){
            if(strcmp(words[k],temp)==0){
                found=k;
                break;
            }
        }
        if(found!=-1){
            freq[found]++;
        }else{
            strcpy(words[count],temp);
            freq[count]=1;
            count++;
        }
    }
    int maxFreq=0,idx=0;
    for(int k=0;k<count;k++){
        if(freq[k]>maxFreq){
            maxFreq=freq[k];
            idx=k;
        }
    }
    return strdup(words[idx]);
}
