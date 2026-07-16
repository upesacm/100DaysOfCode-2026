int compress(char* chars, int charsSize) {
    int index = 0;
    int j, k, i = 0;
    int count, len = 0;

    while(i < charsSize){
        j = i;

        while(j < charsSize && chars[j] == chars[i]){
            j++;
        }

        chars[index++] = chars[i];

        count = j - i;

        if(count > 1){
            char temp[10];
            len = 0;
            while(count > 0){
                temp[len++] = (count % 10) + '0';
                count /= 10;
            }

            for(k = len - 1; k >= 0; k--){
                chars[index++] = temp[k];
            }
        }

        i = j;
    }

    return index;
}