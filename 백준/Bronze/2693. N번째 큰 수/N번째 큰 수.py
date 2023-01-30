import sys

t = int(sys.stdin.readline())

for i in range(t) :
    data = list(map(int, sys.stdin.readline().split()))
    data.sort()
    print(data[7])