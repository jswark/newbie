def toRNA(dna):
   newRNA = dna.replace("T", "U")
   return newRNA

dna = input()
print(toRNA(dna))