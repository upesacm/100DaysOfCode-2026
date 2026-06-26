inp = 'abc'

def answer(inp):
    
    count = 0
    for i in inp.split():
        for j in i:
            count += 1
    return count

print(answer(inp))