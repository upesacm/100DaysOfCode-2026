class Solution {
public:

    struct TrieNode {
        TrieNode* child[2];

        TrieNode() {
            child[0] = nullptr;
            child[1] = nullptr;
        }
    };

    void insert(TrieNode* root, int num) {
        TrieNode* curr = root;

        for (int bit = 30; bit >= 0; bit--) {
            int b = (num >> bit) & 1;

            if (curr->child[b] == nullptr) {
                curr->child[b] = new TrieNode();
            }

            curr = curr->child[b];
        }
    }

    int getMaxXor(TrieNode* root, int num) {
        TrieNode* curr = root;
        int result = 0;

        for (int bit = 30; bit >= 0; bit--) {

            int b = (num >> bit) & 1;
            int opposite = 1 - b;

            if (curr->child[opposite] != nullptr) {
                result |= (1 << bit);
                curr = curr->child[opposite];
            }
            else {
                curr = curr->child[b];
            }
        }

        return result;
    }

    int findMaximumXOR(vector<int>& arr) {

        TrieNode* root = new TrieNode();

        int answer = 0;

        insert(root, arr[0]);

        for (int i = 1; i < arr.size(); i++) {

            answer = max(answer, getMaxXor(root, arr[i]));

            insert(root, arr[i]);
        }

        return answer;
    }
};