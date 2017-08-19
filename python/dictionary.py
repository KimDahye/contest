# -*- coding: utf-8 -*-
from sys import stdin

ord_a = ord("a")

a = [3,4,5,1,2]
b = sorted(a)
print(a)
print(b)
a.sort()
print(a)
#
# def make_edge_matrix(lines, alphabet_matrix):
#     def compare_and_make_edge(str1, str2):
#         l1 = len(str1)
#         l2 = len(str2)
#         l = min(l1, l2)
#         cur_idx = 0
#         while cur_idx < l:
#             if str1[cur_idx] != str2[cur_idx]:
#                 alphabet_matrix[ord(str1[cur_idx])-ord_a][ord(str2[cur_idx])-ord_a] = 1
#                 break
#             cur_idx = cur_idx + 1
#
#     for i in range(0, len(lines)-1):
#         compare_and_make_edge(lines[i], lines[i+1])
#
#
# def print_topological_sort(edge_matrix):
#     unvisited_vertex = list(range(0, 26))
#     topological_sort = []
#
#     def find_noinbounds_unvisited(inbound_count):
#         for i in range(26):
#             if inbound_count[i] == 0 and i not in topological_sort:
#                 return i
#         return -1
#
#     def remove_output_edge(cur_idx):
#         for i in range(26):
#             edge_matrix[cur_idx][i] = 0
#
#     while unvisited_vertex:
#         inbound_count = [0 for r in range(26)]
#         for j in range(26):
#             for i in range(26):
#                 inbound_count[j] = inbound_count[j] + edge_matrix[i][j]
#         cur = find_noinbounds_unvisited(inbound_count)
#
#         # 종료 조건 check - noinbounds 이면서 unvisited 인 게 없는데 아직 unvisited vertex 는 남아있다면
#         if cur == -1 and unvisited_vertex:
#             print("INVALID HYPOTHESIS")
#             return
#
#         unvisited_vertex.remove(cur)
#         topological_sort.append(cur)
#         remove_output_edge(cur)
#
#     print("".join([chr(x + ord_a) for x in topological_sort]))
#
#
# # main
# def main():
#     c = int(input())  # testcase count
#
#     for i in range(c):
#         line_count = int(input())
#         lines = []
#         for j in range(0, line_count):
#             lines.append(input())
#         edge_matrix = [[0 for col in range(26)] for row in range(26)]
#         make_edge_matrix(lines, edge_matrix)
#         print_topological_sort(edge_matrix)
#     exit(0)
#
# main()
