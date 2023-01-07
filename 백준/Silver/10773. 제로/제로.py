from collections import deque
import sys

k = int(sys.stdin.readline())
s = deque()

for i in range(k) :
    s.append(int(sys.stdin.readline()))
    if s[-1] == 0 :
        if len(s)==1 :
            break
        else :
            s.pop()
            s.pop()
print(sum(s))