from itertools import permutations

n = int(input())
list = []
for i in range(n):
    list.append(i+1)

perm = permutations(list)

for seq in perm:
    print(" ".join(str(x) for x in seq))

