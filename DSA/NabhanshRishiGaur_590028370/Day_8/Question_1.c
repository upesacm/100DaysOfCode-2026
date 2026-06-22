bool isPalindrome(char* s) {
    int l = 0;
    int r = strlen(s) - 1;

    while (l < r) {
        while (l < r &&
              !((s[l] >= '0' && s[l] <= '9') ||
                (s[l] >= 'A' && s[l] <= 'Z') ||
                (s[l] >= 'a' && s[l] <= 'z')))
            l++;

        while (l < r &&
              !((s[r] >= '0' && s[r] <= '9') ||
                (s[r] >= 'A' && s[r] <= 'Z') ||
                (s[r] >= 'a' && s[r] <= 'z')))
            r--;

        char c1 = s[l];
        char c2 = s[r];

        if (c1 >= 'A' && c1 <= 'Z') c1 += 32;
        if (c2 >= 'A' && c2 <= 'Z') c2 += 32;

        if (c1 != c2)
            return false;

        l++;
        r--;
    }

    return true;
}
