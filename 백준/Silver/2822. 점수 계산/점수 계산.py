import sys

data = []
for i in range(8) :
    data.append([(i+1), int(sys.stdin.readline())])

result = sorted(data, key=lambda x : x[1])
total = 0
rank = []
for i in range(5) :
    total += result[i+3][1]
    rank.append(result[i+3][0])
rank.sort()
print(total)
print(*rank)
