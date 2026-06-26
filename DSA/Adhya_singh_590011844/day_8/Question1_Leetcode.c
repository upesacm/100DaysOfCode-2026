bool isPalindrome(char *s) {
    int left = 0;
    int right = strlen(s) - 1;

    while (left < right) {
        // Move left pointer to the next alphanumeric character
        while (left < right && !isalnum(s[left])) {
            left++;
        }
        // Move right pointer to the previous alphanumeric character
        while (left < right && !isalnum(s[right])) {
            right--;
        }

        // Compare characters in a case-insensitive manner
        if (tolower(s[left]) != tolower(s[right])) {
            return false;
        }

        left++;
        right--;
    }

    return true;
}
