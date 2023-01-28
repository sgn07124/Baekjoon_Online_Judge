import sys

n = int(sys.stdin.readline())
list = []

for i in range(n) :
    list.append(int(sys.stdin.readline()))
data = sorted(list, reverse=True)
for i in data :
    print(i)