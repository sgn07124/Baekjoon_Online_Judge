import sys
arr = []

n = int(sys.stdin.readline())

for i in range(n) :
    first, second = map(int, input().split())
    arr.append([first, second])
arr = sorted(arr, key=lambda x : x[0])
arr = sorted(arr, key=lambda x : x[1])
last = 0
cnt = 0

for i, j in arr :
    if i >= last :
        cnt += 1
        last = j
print(cnt)