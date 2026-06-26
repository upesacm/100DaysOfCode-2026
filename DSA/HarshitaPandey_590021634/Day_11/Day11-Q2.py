def isIsomorphic(s, t):

    s_len= len(s)
    t_len= len(t) 
    
    if s_len != t_len:
        return False

    s_to_t, t_to_s= {}, {}


    zipped= zip(s,t)

    for char_s, char_t in zipped:
        if char_s in s_to_t and s_to_t[char_s] != char_t:
            return False

        if char_t in t_to_s and t_to_s[char_t] != char_s:
            return False

            
        s_to_t[char_s] = char_t
        t_to_s[char_t] = char_s

    return True



s= str(input("Enter the first string: "))
t= str(input("Enter the second string: "))

print(isIsomorphic(s,t))




