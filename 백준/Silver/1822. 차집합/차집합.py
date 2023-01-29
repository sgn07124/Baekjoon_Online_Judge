import sys

a, b = map(int, sys.stdin.readline().split())

A = set(map(int, sys.stdin.readline().split()))
B = set(map(int, sys.stdin.readline().split()))
result = A - B

if result :
    print(len(result))
    print(*sorted(list(result)))
else :
    print(0)