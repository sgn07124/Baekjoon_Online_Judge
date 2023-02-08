import sys

n = int(sys.stdin.readline())
m = int(sys.stdin.readline())
data = list(map(int, sys.stdin.readline().split()))
cnt = 0
i = 0
j = n-1
data.sort()
while i < j :
    if data[i] + data[j] == m :
        cnt += 1
        i += 1
        j -= 1
    elif data[i] + data[j] < m :
        i += 1
    else :
        j -= 1
print(cnt)