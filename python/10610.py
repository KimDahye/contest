# -*- coding: utf-8 -*-
from sys import stdin


def get_max_multiply_of_30():
    line = stdin.readline()
    digits = list(map(int, line[: -1]))

    sum = 0
    for c in digits:
        sum = sum + int(c)

    if (sum % 3 != 0) or (not 0 in digits):
        print('-1')
        return
    else:
        digits.sort(reverse=True)
        for i in digits:
            print(i, end='')


get_max_multiply_of_30()