from sys import stdin


# Sieve of Eratosthenes
def eratosthenes(n, k):
    nums = list(range(2, n + 1))  # 2 ~ n
    count = 0

    while len(nums) > 0:
        cur_index = 0
        while nums[cur_index] == -1:
            cur_index = cur_index + 1
        multiple = nums[cur_index]
        while cur_index < len(nums):
            if nums[cur_index] != -1:
                candidate = nums[cur_index]
                nums[cur_index] = -1
                count = count + 1
                if count == k:
                    return candidate
            cur_index = cur_index + multiple

args = [int(e) for e in stdin.readline().split()]

print(eratosthenes(args[0], args[1]))
