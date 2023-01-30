import sys

a, b, c, d = map(str, sys.stdin.readline().split())

n = a + b
m = c + d
total = int(n) + int(m)
print(total)