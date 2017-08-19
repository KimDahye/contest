# -*- coding: utf-8 -*- 
from sys import stdin


def swap(s1, s2):
    return s2, s1


class DisjointSet:
    def __init__(self, members):
        self.members = members
        self.parent = []  # parent[i] = i의 부모 번호, i가 루트라면 자기자신.
        self.height = [1] * members  # height[i] = i가 루트인 경우, i를 루트로 하는 트리의 height
        self.size = [1] * members  # size[i] = i가 루트인 경우, 해당 트리의 원소 개수
        self.enemy = [-1] * members  # enemy[i] = i가 루트인 경우, 해당 집합과 적대관계에 있는 루트의 번호

        # parent array init
        for i in range(0, members):
            self.parent.append(i)

    def find_root(self, u):
        if (u == self.parent[u]): return u
        # self.parent[u] = self.find_root(self.parent[u])
        # return self.parent[u]
        return self.find_root(self.parent[u])

    def merge(self, u, v):
        if (u == -1 or v == -1): return max(u, v)
        u_root = self.find_root(u)
        v_root = self.find_root(v)
        if (u_root == v_root): return u_root
        if (self.height[u] > self.height[v]): u_root, v_root = swap(u_root, v_root)
        self.parent[u_root] = v_root
        if (self.height[u] == self.height[v]): self.height[v_root] += 1
        self.size[v_root] = self.size[v_root] + self.size[u_root]
        return v_root

    # u, v가 서로 적대하는 관계
    def dis(self, u, v):
        u_root = self.find_root(u);
        v_root = self.find_root(v)
        if (u_root == v_root): return False

        u_enemy = self.enemy[u_root];
        v_enemy = self.enemy[v_root]
        a = self.merge(u_enemy, v_root)
        b = self.merge(v_enemy, u_root)
        self.enemy[b] = a
        self.enemy[a] = b
        return True

    # u, v가 동지인 관계
    def ack(self, u, v):
        u_root = self.find_root(u);
        v_root = self.find_root(v)
        u_enemy = self.enemy[u_root];
        v_enemy = self.enemy[v_root]
        if (u_enemy == v_root): return False

        a = self.merge(u_root, v_root)
        b = self.merge(u_enemy, v_enemy)
        self.enemy[a] = b
        if (b != -1): self.enemy[b] = a
        return True


def max_party_num(disjoint_set):
    count = 0
    for i in range(0, disjoint_set.members):
        if (i == disjoint_set.parent[i]):
            i_enemy = disjoint_set.enemy[i]
            if (i_enemy > i): continue
            enemy_size = 0 if i_enemy == -1 else disjoint_set.size[i_enemy]
            count = count + max(disjoint_set.size[i], enemy_size)

    return count


def print_result(members, comments):
    disjoint_set = DisjointSet(members)
    goahead = True
    for i in range(1, comments + 1):
        comment_info = stdin.readline().split()
        type = comment_info[0]
        u = int(comment_info[1])
        v = int(comment_info[2])
        if type == 'DIS':
            is_contradict = not disjoint_set.dis(u, v)
        else:
            is_contradict = not disjoint_set.ack(u, v)

        if is_contradict:
            print('CONTRADICTION AT ' + str(i))
            goahead = False
            break

    for a in range(i, comments): stdin.readline()

    if (goahead): print('MAX PARTY SIZE IS ' + str(max_party_num(disjoint_set)))


# main
c = int(stdin.readline())  # testcase count

for i in range(0, c):
    info = stdin.readline().split()
    members = int(info[0])
    comments = int(info[1])
    print_result(members, comments)

"""
한 집합과 다른 집합이 서로 적대관계라면, 이 쌍끼리만 1:1 대응된다.
따라서 각 집합은 적대관계가 없거나(모르거나), 서로 적대관계인 집합이 딱 하나뿐이다. 
"""
