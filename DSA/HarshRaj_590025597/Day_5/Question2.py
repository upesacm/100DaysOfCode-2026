# Check Equal Arrays

# Take input for array a
a = list(map(int, input("Enter elements of array a (space-separated): ").split()))

# Take input for array b
b = list(map(int, input("Enter elements of array b (space-separated): ").split()))

# Check if sizes are different
if len(a) != len(b):
    print("false")
else:
    freq = {}

    # Count frequency from array a
    for x in a:
        freq[x] = freq.get(x, 0) + 1

    # Decrease frequency using array b
    for x in b:
        freq[x] = freq.get(x, 0) - 1

    # Check if all frequencies are zero
    equal = True
    for value in freq.values():
        if value != 0:
            equal = False
            break

    if equal:
        print("true")
    else:
        print("false")
