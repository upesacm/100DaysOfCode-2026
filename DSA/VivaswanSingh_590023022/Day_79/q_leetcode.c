char* addBinary(char* a, char* b)
{
    int i = strlen(a) - 1;
    int j = strlen(b) - 1;
    int carry = 0;

    int n = strlen(a) > strlen(b) ? strlen(a) : strlen(b);

    char *result = malloc(n + 2);
    int k = 0;

    while (i >= 0 || j >= 0 || carry)
    {
        int sum = carry;

        if (i >= 0)
            sum += a[i--] - '0';

        if (j >= 0)
            sum += b[j--] - '0';

        result[k++] = (sum % 2) + '0';
        carry = sum / 2;
    }

    result[k] = '\0';

    for (int l = 0, r = k - 1; l < r; l++, r--)
    {
        char temp = result[l];
        result[l] = result[r];
        result[r] = temp;
    }

    return result;
}