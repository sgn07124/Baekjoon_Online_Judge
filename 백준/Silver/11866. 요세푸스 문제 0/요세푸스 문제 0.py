import sys
from collections import deque

n, k = map(int, sys.stdin.readline().split())
q = deque()
for i in range(1, n+1) :
    q.append(i)
print('<', end='')
while q :
    for i in range(k-1) :  # 입력받은  k 번째까지의 요소를 없애고, 없앤 요소들을 뒤에 추가한다.
        q.append(q[0])  # q의 마지막에 q[0](첫번째수)를 추가해주고,
        q.popleft()  # q의 첫번째 수를 pop한다.
        # 1,2,3,4,5,6,7 -> 1,2,3,4,5,6,7,1 -> 2,3,4,5,6,7,1
    print(q.popleft(), end='')  # 첫번째 수를 출력하면서 pop한다.
    if q :  # q에 요소가 남아있다면
        print(', ', end='')
print('>')