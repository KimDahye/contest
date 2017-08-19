# -*- coding: utf-8 -*-
from sys import stdin


def print_sum_of_eatable_color_ball():
    balls = int(stdin.readline())

    # initialize
    colorball_list = []
    for i in range(0, balls):
        args = [int(e) for e in stdin.readline().split()]
        dic = {
            'index': i,
            'color': args[0],
            'size': args[1],
            'sumOfColor1': 0,
            'sumOfColor2': 0,
            'sumOfColor3': 0,
            'sumOfColor4': 0,
            'sumOfEatable': 0
        }
        colorball_list.append(dic)

    # sort by size
    sorted_by_size = sorted(colorball_list, key=lambda k: k['size'], reverse=True)

    # calculate sumOfColr1,2,3,4
    first_color = sorted_by_size[0]['color']
    sorted_by_size[0]['sumOfColor'+str(first_color)] = sorted_by_size[0]['size']
    for i in range(1, len(sorted_by_size)):
        pre = sorted_by_size[i-1]
        cur = sorted_by_size[i]

        # 이전꺼 반영
        cur['sumOfColor1'] = pre['sumOfColor1']
        cur['sumOfColor2'] = pre['sumOfColor2']
        cur['sumOfColor3'] = pre['sumOfColor3']
        cur['sumOfColor4'] = pre['sumOfColor4']

        # 이번꺼 누적
        cur_color = cur['color']
        color_key = 'sumOfColor' + str(cur_color)
        cur[color_key] = pre[color_key] + cur['size']

    # calculate sumOfEatable
    last = sorted_by_size[-1]
    first_sum_of_eatable = get_sum_of_eatable(first_color, last)
    sorted_by_size[0]['sumOfEatable'] = first_sum_of_eatable

    for i in range(1, len(sorted_by_size)):
        pre = sorted_by_size[i-1]
        cur = sorted_by_size[i]
        cur_color = cur['color']
        sum_of_eatable = get_sum_of_eatable(cur_color, last, pre)
        sorted_by_size[i]['sumOfEatable'] = sum_of_eatable

    # sort by index and print result
    sorted_by_index = sorted(sorted_by_size, key=lambda k: k['index'])
    for e in sorted_by_index:
        print(e['sumOfEatable'])

    return


def get_sum_of_eatable(cur_color, last, pre=None):
    if pre is None:
        pre = {
            'sumOfColor1': 0,
            'sumOfColor2': 0,
            'sumOfColor3': 0,
            'sumOfColor4': 0,
        }

    sum_of_eatable = 0
    for color in range(1, 5):
        if cur_color == color:
            continue
        color_key = 'sumOfColor' + str(color)
        sum_of_eatable = sum_of_eatable + (last[color_key] - pre[color_key])
    return sum_of_eatable

print_sum_of_eatable_color_ball()
