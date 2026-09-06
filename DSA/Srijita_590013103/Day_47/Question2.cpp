class Solution {
public:
    int kthElement(vector<int>& A, vector<int>& B, int k) {

        int n = A.size();
        int m = B.size();

       
        if (n > m)
            return kthElement(B, A, k);

        int low = max(0, k - m);
        int high = min(k, n);

        while (low <= high) {

            int cutA = (low + high) / 2;
            int cutB = k - cutA;

            int leftA = (cutA == 0) ? INT_MIN : A[cutA - 1];
            int rightA = (cutA == n) ? INT_MAX : A[cutA];

            int leftB = (cutB == 0) ? INT_MIN : B[cutB - 1];
            int rightB = (cutB == m) ? INT_MAX : B[cutB];

            if (leftA <= rightB && leftB <= rightA) {
                return max(leftA, leftB);
            }

            else if (leftA > rightB) {
                high = cutA - 1;
            }

            else {
                low = cutA + 1;
            }
        }

        return -1;
    }
};