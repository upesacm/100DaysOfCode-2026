bool isIsomorphic(char *s, char *t){
    if(strlen(s) != strlen(t)){
         return false;
    }
    for(int i=0;s[i]!='\0';i++){
        int occur_chs=-1;
        int occur_cht=-1;
        for(int k=0;k<=i;k++){
            if(s[k]==s[i]){
                occur_chs=k;
                break;
            }
        } for(int j=0;j<=i;j++) {
            if(t[j]==t[i]) {
                occur_cht=j;
                break;
            }
        } if(occur_chs != occur_cht){
            return false;
        }
    }
    return true;
}