import sys
from collections import Counter

n = int(sys.stdin.readline())
N = list(sys.stdin.readline().split())
m = int(sys.stdin.readline())
M = list(sys.stdin.readline().split())

C = Counter(N)
print(' '.join('1' if m in C else '0' for m in M))