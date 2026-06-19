# problem 2
# Check equal arrays

a = list(map(int, input("Enter first array(separated by spaces): ").split()))
b = list(map(int, input("Enter second array(separated by spaces): ").split()))

if len(a) != len(b):
    print("false")
else:
    freq = {}

    for i in a:
        freq[i] = freq.get(i, 0) + 1

    for i in b:
        if i not in freq:
            print("false")
            break

        freq[i] -= 1

        if freq[i] < 0:
            print("false")
            break
    else:
        print("true")