from itertools import product

seq = input().replace(" ", "")
n = int(input())

for i in product(seq, repeat = n):
    print("".join(str(x) for x in i))