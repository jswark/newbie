from collections import defaultdict


class DNASequence(object):
    def __init__(self, sequence, id):
        self.sequence = sequence
        self.id = id
    def countBases(self):
        count_dict = defaultdict(int)
        for base in self.sequence:
            count_dict[base] += 1
        return count_dict

    def transcribe(self):
        rna = self.sequence.replace('T', 'U')
        return rna

    def reverseComplement(self):
        watson_crick = {'A': 'T', 'C': 'G', 'G': 'C', 'T': 'A'}
        complement = ''
        for base in self.sequence:
            complement += watson_crick[base]
            rev_complement = complement[::-1]
        return rev_complement

    def GCContent(self):
        counts = self.countBases()
        gc = counts['G'] + counts['C']
        gc_percent = float(gc) / len(self.sequence)
        return gc_percent


class FASTAFile(object):
    def __init__(self, path):
        self.path = path

    def sequences(self):
        found_sequences = []
        with open(self.path, 'r') as input:
            sequence = ''
            for i, line in enumerate(input):
                if i == 0:
                    id = line.rstrip('\n').lstrip('>')
                else:
                    if line.startswith('>'):
                        new_sequence_object = DNASequence(sequence, id)
                        found_sequences.append(new_sequence_object)
                        sequence = ''
                        id = line.rstrip('\n').lstrip('>')
                    else:
                        sequence += line.rstrip('\n')
            else:
                new_sequence_object = DNASequence(sequence, id)
                found_sequences.append(new_sequence_object)
        return found_sequences


path = 'mine.txt'
my_sequences = FASTAFile(path).sequences()
my_sequences.sort(key=lambda x: x.GCContent(), reverse=True)

top_GC = my_sequences[0]
print(top_GC.id)
print(top_GC.GCContent()*100)
