def equal(a, b):
    if len(a) != len(b):
        return False
    return sorted(a) == sorted(b)

n = int(input("length = "))
a = [int(input(f"num {i+1} = ")) for i in range(n)]
n = int(input("length = "))
b = [int(input(f"num {i+1} = ")) for i in range(n)]

print(equal(a, b))