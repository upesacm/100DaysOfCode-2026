s = input()

print(''.join('.' + c.lower()
              for c in s
              if c.lower() not in 'aeiouy'))