# -*- coding: utf-8 -*-
# prob_url: https://www.acmicpc.net/problem/10800
from sys import stdin


max_size = 2000
# 1 <= color <= len(balls)
# 1 <= size <= 2000
def print_sum_of_eatable_color_ball():
    balls = int(stdin.readline())

    # initialize
    colorball_list = []
    accumulated_size = [0]*max_size
    for i in range(0, balls):
        args = [int(e) for e in stdin.readline().split()]
        color = args[0]
        size = args[1]
        accumulated_size[size] = accumulated_size[size] + size
        dic = {
            'index': i,
            'color': color,
            'size': size,
            'eatable_size': 0,
        }
        colorball_list.append(dic)

    # get list of sum_of_smaller_size
    sum_of_smaller_size = [0]*max_size
    for i in range(1, max_size):
        sum_of_smaller_size[i] = sum_of_smaller_size[i-1] + accumulated_size[i-1]

    # 색깔 그룹에서 size보다 작은 size들 더해놓은 값
    sorted_by_color_size = sorted(colorball_list, key=lambda k: (k['color'], k['size']))

    is_new_color_start = True
    for i in range(0, len(sorted_by_color_size)):
        index = sorted_by_color_size[i]['index']
        if is_new_color_start:
            first_size = sorted_by_color_size[i]['size']
            colorball_list[index]['eatable_size'] = sum_of_smaller_size[first_size] # (- 0) 이므로 생략
            accumulated_prev_size = first_size
            prev_same_color_eatable_size = 0
        else:
            pre_size = sorted_by_color_size[i-1]['size']
            cur_size = sorted_by_color_size[i]['size']
            # 사이즈 새롭게 시작
            if pre_size != cur_size:
                same_color_eatable_size = prev_same_color_eatable_size + accumulated_prev_size
                eatable_size = sum_of_smaller_size[cur_size] - same_color_eatable_size
                colorball_list[index]['eatable_size'] = eatable_size
                accumulated_prev_size = cur_size
                prev_same_color_eatable_size = same_color_eatable_size
            # 사이즈 계속 이어짐
            else:
                accumulated_prev_size = accumulated_prev_size + cur_size

        if i != len(sorted_by_color_size)-1:
            cur = sorted_by_color_size[i]
            ne = sorted_by_color_size[i + 1]
            is_new_color_start = cur['color'] != ne['color']

    # print
    for e in colorball_list:
        print(e['eatable_size'])

    return

print_sum_of_eatable_color_ball()
