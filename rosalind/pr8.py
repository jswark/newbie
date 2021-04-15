dna = input()
sub = input()

allpos = []
pos = 0
while dna.find(sub, pos) != -1:
    pos = dna.find(sub, pos)
    allpos.append(pos+1)
    pos +=1

print(*allpos)