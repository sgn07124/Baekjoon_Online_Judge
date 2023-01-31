import sys
n = int(sys.stdin.readline())
data = []
for i in range(n) :
    data.append(int(sys.stdin.readline()))
result = sorted(data, reverse=False)
for i in range(n) :
    print(result[i])