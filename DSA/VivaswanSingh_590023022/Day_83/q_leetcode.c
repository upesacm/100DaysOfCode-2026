int singleNumber(int* nums, int numsSize)
{
    unsigned int result = 0;

    for (int bit = 0; bit < 32; bit++)
    {
        int count = 0;

        for (int i = 0; i < numsSize; i++)
        {
            unsigned int num = (unsigned int)nums[i];

            if ((num >> bit) & 1u)
                count++;
        }

        if (count % 3 != 0)
            result |= (1u << bit);
    }

    return (int)result;
}