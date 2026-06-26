str=input("enter string")
total=0
count=0

for i in str:
    count += 1

print("Length =", count)
if count % 2 == 0:
    print("Chat with her!")
else:
    print("Ignore him!")