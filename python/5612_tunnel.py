from sys import stdin


def find_max_count(n, cur):
    max_count = cur
    for i in range(0, n):
        arr = stdin.readline().split(' ')
        input = int(arr[0])
        output = int(arr[1])
        cur = cur + input - output

        if cur < 0:
            return 0

        if max_count < cur:
            max_count = cur

    return max_count


# main
n = int(stdin.readline())  # testcase count
initialCount = int(stdin.readline())
cur = initialCount
print(find_max_count(n, cur))
