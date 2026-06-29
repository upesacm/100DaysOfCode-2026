def avg_repeat_distance(s):
    positions = {}

    for i, ch in enumerate(s):
        positions.setdefault(ch, []).append(i)

    distances = []

    for pos_list in positions.values():
        if len(pos_list) > 1:
            for i in range(1, len(pos_list)):
                distances.append(pos_list[i] - pos_list[i - 1])

    # No repeated characters = maximum score
    if not distances:
        return float('inf')

    return sum(distances) / len(distances)


s1 = input("Enter string 1: ")
s2 = input("Enter string 2: ")

score1 = avg_repeat_distance(s1)
score2 = avg_repeat_distance(s2)

if score1 >= score2:
    print(s1)
else:
    print(s2)
