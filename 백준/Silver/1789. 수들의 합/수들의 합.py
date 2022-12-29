import sys

s = int(sys.stdin.readline())
result = 0
n = 0
for i in range(1, s+1) :
    result += i
    n += 1
    if result > s :
        n -= 1
        break
print(n)