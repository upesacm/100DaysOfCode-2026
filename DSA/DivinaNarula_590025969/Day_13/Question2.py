# Better String

def count_distinct_subsequences(string):
    length = len(string)

    dp = [0] * (length + 1)
    dp[0] = 1

    last_occurrence = {}

    for i in range(1, length + 1):
        current_char = string[i - 1]

        dp[i] = 2 * dp[i - 1]

        if current_char in last_occurrence:
            previous_index = last_occurrence[current_char]
            dp[i] -= dp[previous_index - 1]

        last_occurrence[current_char] = i

    return dp[length]


def better_string(first_string, second_string):
    first_count = count_distinct_subsequences(first_string)
    second_count = count_distinct_subsequences(second_string)

    if first_count >= second_count:
        return first_string
    else:
        return second_string


first_string = input("Enter first string: ")
second_string = input("Enter second string: ")

print("Better String:", better_string(first_string, second_string))