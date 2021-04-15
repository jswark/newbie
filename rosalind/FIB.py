def fib(n, k):
    if n == 1:
        return 1
    if n == 2:
        return 1
    else:
        return fib(n-1, k) + k*fib(n-2, k)

n, k = map(int, input().split())

print(fib(n, k))