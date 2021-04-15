def countNuc(dna):
    dict = {"A": 0, "C": 0, "G": 0, "T": 0}
    for nuc in dna:
        dict[nuc.upper()] += 1
    return dict

dna = input()
newDict = countNuc(dna)
print(newDict["A"], newDict["C"], newDict["G"], newDict["T"])