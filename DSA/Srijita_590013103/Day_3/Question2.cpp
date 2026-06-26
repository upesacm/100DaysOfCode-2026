class Solution {
public:
    int firstOccurrence(vector<int>& arr, int target) {
        int low = 0, high = arr.size() - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                ans = mid;
                high = mid - 1; 
            }
            else if (arr[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return ans;
    }

    int lastOccurrence(vector<int>& arr, int target) {
        int low = 0, high = arr.size() - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                ans = mid;
                low = mid + 1; 
            }
            else if (arr[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return ans;
    }

    int countFreq(vector<int>& arr, int target) {
        int first = firstOccurrence(arr, target);

        if (first == -1)
            return 0;

        int last = lastOccurrence(arr, target);

        return last - first + 1;
    }
};