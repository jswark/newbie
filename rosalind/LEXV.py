def gen(string, max_length):
    print(string)
    if len(string) == max_length:
        return
    for c in alphabet:
        gen(string + c, max_length)

alphabet = input().replace(" ", "")
n = int(input())
for c in alphabet:
    gen(c, n)