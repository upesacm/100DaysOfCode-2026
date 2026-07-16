bool isHappy(int n) {
    int slow = n, fast = n;

    while (1) {
        // Move slow one step
        int sum = 0, temp = slow;
        while (temp > 0) {
            int digit = temp % 10;
            sum += digit * digit;
            temp /= 10;
        }
        slow = sum;

        // Move fast two steps
        for (int k = 0; k < 2; k++) {
            sum = 0;
            temp = fast;
            while (temp > 0) {
                int digit = temp % 10;
                sum += digit * digit;
                temp /= 10;
            }
            fast = sum;
        }

        if (fast == 1)
            return true;

        if (slow == fast)
            return false;
    }
}