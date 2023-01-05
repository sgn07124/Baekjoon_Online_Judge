from collections import deque
import sys

q = deque()
n = int(sys.stdin.readline())

for i in range(1,n+1) :
    q.append(i)

while True :
    if len(q) == 1 :
        break
    else :
        tmp = 0
        q.popleft()
        tmp = q[0]
        q.popleft()
        q.append(tmp)

print(q[0])