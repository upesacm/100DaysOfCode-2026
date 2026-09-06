class Solution{
public:
    bool isPoweOfTwo(int n){
        return n==0 || (n & (n-1)) == 0;
    }
};