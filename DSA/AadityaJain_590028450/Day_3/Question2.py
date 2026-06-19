'''
Number of Occurrence
Explanation
Given an sorted integer array and a target value, count the number of occurrences of the target in the array and return the result.
'''

a = list(map(int, input("Enter the  elements: ").split()))
key = int(input("Enter the target: "))

print("Number of occurrences:", a.count(key))