def reverseComp(dna):
   pattern = dna.maketrans('ATCG', 'TAGC')
   newRNA = dna.translate(pattern)

   return newRNA[::-1]

dna = input()
print(reverseComp(dna))