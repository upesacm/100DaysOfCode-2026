def isPalindrome(s):
    
    filtered = ''.join(c.lower() for c in s if c.isalnum())
    return filtered == filtered[::-1]

print(isPalindrome("A man, a plan, a canal: Panama"))  # true
print(isPalindrome("race a car"))                       # false
print(isPalindrome(" "))                                # true