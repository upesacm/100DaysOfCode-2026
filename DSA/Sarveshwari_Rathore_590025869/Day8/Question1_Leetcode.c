bool isPalindrome(char* s){
    int left=0;
    int right=strlen(s)-1;
    while(left < right){
        while(left<right && !(isalpha(s[left]) || isdigit(s[left]))){
            left++;
        }
        while(left<right && !(isalpha(s[right]) || isdigit(s[right]))){
            right--;
        }
        if(tolower(s[left]) != tolower(s[right])){
            return false;
        }
        left++;
        right--;
    }
    return true;
}