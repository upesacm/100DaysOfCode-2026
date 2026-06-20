# problem 2
# union of two sorted arrays

a = list(map(int, input("Enter first sorted array: ").split()))
b = list(map(int, input("Enter second sorted array: ").split()))

i = 0
j = 0
answer = []

while i < len(a) and j < len(b):

    if a[i] < b[j]:
        if not answer or answer[-1] != a[i]:
            answer.append(a[i])
        i += 1

    elif a[i] > b[j]:
        if not answer or answer[-1] != b[j]:
            answer.append(b[j])
        j += 1

    else:
        if not answer or answer[-1] != a[i]:
            answer.append(a[i])
        i += 1
        j += 1

while i < len(a):
    if not answer or answer[-1] != a[i]:
        answer.append(a[i])
    i += 1

while j < len(b):
    if not answer or answer[-1] != b[j]:
        answer.append(b[j])
    j += 1

print(answer)