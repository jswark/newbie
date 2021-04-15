from math import factorial as FACT

k, N = map(int, input().split())

P = 2 ** k
prob = 0

for i in range(N, P + 1):
    probnew = (FACT(P) / (FACT(i) * FACT(P - i))) * (0.25 ** i) * (0.75 ** (P - i))
    prob += probnew

print(round(prob, 3))
