import sys
n = int(sys.stdin.readline())
data = []
for i in range(n) :
    age, name = list(sys.stdin.readline().split())
    data.append([int(age), name])

data = sorted(data, key=lambda x : x[0])

for i in range(n) :
    print(data[i][0], data[i][1])