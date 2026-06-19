def equalArr(a, b):
    if len(a) != len(b):
        return False
    freq = {};
    for element in a:
        freq[element] = freq.get(element, 0) + 1
    for element in b:
        if freq.get(element, 0) == 0:
            return False
        freq[element] -= 1
    return True
        
if __name__ == "__main__":
    
    exampleArr1 = [1, 2, 3]
    exampleArr2 = [1, 2, 2]
    exampleArr3 = [3, 2, 1]
    exampleArr4 = [1, 2, 3, 4]
    
    print(equalArr(exampleArr1, exampleArr2))
    print(equalArr(exampleArr1, exampleArr3))
    print(equalArr(exampleArr1, exampleArr4))