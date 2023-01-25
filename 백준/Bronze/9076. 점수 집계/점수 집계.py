import sys

n = int(sys.stdin.readline())
data = []

for i in range(n) :
    total = 0
    data = list(map(int, sys.stdin.readline().split()))
    data.sort()
    if data[3] - data[1] >= 4 :
        print("KIN")
    else :
        print(sum(data[1:4]))
