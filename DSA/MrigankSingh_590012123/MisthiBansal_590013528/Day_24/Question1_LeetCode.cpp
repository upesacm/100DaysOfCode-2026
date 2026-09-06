class Solution {
public:
    int summ(int num)
    {
        int sum = 0;

        while(num != 0)
        {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }

        return sum;
    }

    bool isHappy(int n) {

        unordered_set<int> seen;

        while(n != 1)
        {
            // If we've seen this number before,
            // we're in a cycle.
            if(seen.count(n))
                return false;

            seen.insert(n);

            n = summ(n);
        }

        return true;
    }
};