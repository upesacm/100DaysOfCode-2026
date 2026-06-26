#pragma GCC optimize("Ofast,unroll-loops,fast-math")
#pragma GCC target("avx,avx2,fma,sse4,popcnt,lzcnt,bmi,bmi2")

#include <bits/stdc++.h>
using namespace std;

using ll = long long;
using ull = unsigned long long;
using ld = long double;

static constexpr size_t mxal = alignof(max_align_t);
alignas(mxal) static unsigned char buf[256 * 1024 * 1024];
static size_t pos = 0;

void* operator new(size_t sz) {
    size_t pad = (mxal - (pos % mxal)) % mxal;
    pos += pad + sz;
    return (void*)(&buf[pos - sz]);
}

void* operator new[](size_t sz) { return operator new(sz); }

void operator delete(void*) noexcept {}
void operator delete[](void*) noexcept {}
void operator delete(void*, size_t) noexcept {}
void operator delete[](void*, size_t) noexcept {}
class Solution {
public:
    bool isPalindrome(string s) {
        int left = 0;
        int right = s.size() - 1;
       while (left < right) {
    while (left < right && !isalnum(s[left]))
        left++;
    while (left < right && !isalnum(s[right]))
        right--;
    if (tolower(s[left]) != tolower(s[right]))
        return false;
    
    left++;
    right--;
}
return true;
    }
};