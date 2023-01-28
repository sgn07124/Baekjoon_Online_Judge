import sys
n, m = map(int, sys.stdin.readline().split())
N = list(map(int, sys.stdin.readline().split()))
M = list(map(int, sys.stdin.readline().split()))
data = N + M
data.sort()
print(*data)