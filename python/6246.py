# -*- coding: utf-8 -*-
from sys import stdin


def main():
    line = stdin.readline()
    slot_size, num = [int(x) for x in line.split(" ")]
    balloon = [0]*(slot_size + 1)
    for c in range(0, num):
        line = stdin.readline()
        start, step = [int(x) for x in line.split(" ")]
        for index in range(start, slot_size+1, step):
            balloon[index] = 1

    print(slot_size - sum(balloon))

main()