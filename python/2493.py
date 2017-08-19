# -*- coding: utf-8 -*-
from sys import stdin


def print_recivers():
    size = int(stdin.readline())
    towers = list(map(int, stdin.readline().split()))
    result = [0] * size
    cur_max = towers[size - 1]
    last_idx_to_fill = size - 1
    for i in range(size-2, 0, -1):
        if towers[i] > cur_max:
            fill_numbers(result, i + 1, i + 1, last_idx_to_fill)
            cur_max = towers[i]
            last_idx_to_fill = i

    for i in result[:-1]:
        print(i, end=' ')
    print(result[size-1], end='')


def fill_numbers(result, num, left, right):
    for i in range(left, right + 1):
        result[i] = num


print_recivers()
