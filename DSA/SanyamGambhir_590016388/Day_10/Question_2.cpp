#include <iostream>
#include <string>
#include <unordered_set>

// Using the standard namespace allows us to omit 'std::' before string, cout, etc.
using namespace std;

string determineGender(const string& s) {
    // Insert all characters into an unordered_set to filter duplicates
    unordered_set<char> distinctChars(s.begin(), s.end());
    
    // If the number of distinct characters is even, it's a female
    if (distinctChars.size() % 2 == 0) {
        return "CHAT WITH HER!";
    } else {
        return "IGNORE HIM!";
    }
}

int main() {
    // Test cases
    string user1 = "wjmzbmr"; // 6 distinct characters (w, j, m, z, b, r) -> Even
    string user2 = "xiaodao"; // 5 distinct characters (x, i, a, o, d) -> Odd
    string user3 = "abc";     // 3 distinct characters (a, b, c) -> Odd

    cout << "Result for 'wjmzbmr': " << determineGender(user1) << endl; 
    cout << "Result for 'xiaodao': " << determineGender(user2) << endl; 
    cout << "Result for 'abc':     " << determineGender(user3) << endl; 

    return 0;
}