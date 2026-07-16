int compress(char* chars, int charsSize)
{
    int read = 0;
    int write = 0;

    while (read < charsSize)
    {
        char current = chars[read];
        int count = 0;

        while (read < charsSize && chars[read] == current)
        {
            count++;
            read++;
        }

        chars[write++] = current;

        if (count > 1)
        {
            char temp[10];
            int index = 0;

            while (count > 0)
            {
                temp[index++] = (count % 10) + '0';
                count /= 10;
            }

            while (index > 0)
            {
                chars[write++] = temp[--index];
            }
        }
    }

    return write;
}