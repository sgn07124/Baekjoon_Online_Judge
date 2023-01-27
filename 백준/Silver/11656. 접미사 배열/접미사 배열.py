s = input()
data = []
for i in range(len(s)) :
    data.append(s[i:])
data.sort()
for i in data :
    print(i)