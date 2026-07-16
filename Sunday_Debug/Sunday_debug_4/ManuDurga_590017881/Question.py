def num_boats(weights, limit):
   weights.sort(reverse=True)
   print(weights)
   left = 0
   right = len(weights) - 1
   boats = 0
   while left < right:
       if weights[left] + weights[right] > limit:
           boats+=1
           
           print('[',weights[left],'  ]')#Too heavy together, sent alone
           left += 1

       else:
           boats += 1
           print('[',weights[left],weights[right],']')#1 heavy 1 light together
           right -=1
           left +=1
   print(boats)
weights = list(map(int, input().split()))
limit = int(input())
num_boats(weights, limit) 
