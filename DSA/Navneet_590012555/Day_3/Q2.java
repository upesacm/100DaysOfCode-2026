def count_occ(arr, target):
    l = arr.index(target)
    r = len(arr) - 1 - arr[::-1].index(target)
    return r - l + 