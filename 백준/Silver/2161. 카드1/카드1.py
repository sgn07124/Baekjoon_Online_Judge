from collections import deque
import sys

n = int(sys.stdin.readline())
q = deque()

for i in range(1, n+1) :
    q.append(i)
trash = []
while q :
    trash.append(q.popleft())
    if not q :
        break
    q.append(q.popleft())
print(*trash)
# print(trash) -> [1, 3, 5, 7, 4, 2, 6]
# print(*trash) -> 1 3 5 7 4 2 6