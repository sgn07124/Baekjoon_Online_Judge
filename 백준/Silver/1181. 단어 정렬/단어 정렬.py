n = int(input())
word = []
len1 = []

for i in range(n) :
    word.append(input())

set_1 = set(word)
word = list(set_1)
word.sort()
word.sort(key=len)


for i in word :
    print(i)