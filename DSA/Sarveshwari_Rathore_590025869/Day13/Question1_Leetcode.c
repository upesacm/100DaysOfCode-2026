int isbanned(char *word,char **banned,int bannedSize) {
    for(int i=0; i<bannedSize;i++) {
        if(strcmp(word,banned[i]) == 0)
            return 1;
    }
    return 0;
}
int findw(char words[][50],int total,char *word) {
    for (int i=0; i<total; i++) {
        if (strcmp(words[i], word) == 0)
            return i;
    } return -1;
}
char* mostCommonWord(char* paragraph, char** banned, int bannedSize) {
    char words[100][50];
    int freq[100] = {0};
    int total = 0;
    char temp[50];
    int pos=0;
    int n=strlen(paragraph);

    for (int i=0; i<=n; i++) {
        if (isalpha((unsigned char)paragraph[i])) {
            temp[pos++] = tolower((unsigned char)paragraph[i]);
        } else{
            if(pos > 0){
                temp[pos] = '\0';
                if(!isbanned(temp, banned, bannedSize)){
                    int found = -1;
                    for(int j = 0; j < total; j++){
                        if(strcmp(words[j], temp) == 0){
                            found = j;
                            break;
                        }
                    } if(found == -1){
                        strcpy(words[total], temp);
                        freq[total] = 1;
                        total++;
                    }else{
                        freq[found]++;
                    }
                } pos = 0;
            }
        }
    }
    int maxIndex = 0;
    for (int i=1; i<total; i++) {
        if (freq[i] > freq[maxIndex]) {
            maxIndex = i;
        }
    }
    char *ans = malloc(strlen(words[maxIndex]) + 1);
    strcpy(ans,words[maxIndex]);
    return ans;
}