import sys

n = int(sys.stdin.readline())

for i in range(n) :
    li = []
    li = map(str, sys.stdin.readline().split())
    for j in li :
        print(j[::-1], end=" ")