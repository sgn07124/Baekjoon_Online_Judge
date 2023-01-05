from collections import deque
import sys

t = int(input())
for i in range(t) :
    p = sys.stdin.readline().rstrip()
    n = int(sys.stdin.readline())
    arr = sys.stdin.readline().rstrip()[1:-1].split(",")
    queue = deque(arr)

    rev, front, back = 0, 0, len(queue)-1
    flag = 0
    if n == 0 :
        queue = []
        front = 0
        back = 0
    for j in p :
        if j == "R" :
            rev += 1  # Reverse를 해야 할 때마다, 매번 deque를 뒤집어주면 시간초과가 발생하므로 Reverse를 실행하지 않고, 뒤집는 횟수를 기억해둔다.
        elif j == "D" :
            if len(queue) < 1 :
                flag = 1
                print("error")
                break
            else :
                if rev % 2 == 0 :  # 뒤집는 횟수가 짝수이므로 popleft
                    queue.popleft()
                else :
                    queue.pop()
    if flag == 0 :
        if rev % 2 == 0 :
            print("[" + ",".join(queue) + "]")
        else :
            queue.reverse()  # Reverse(뒤집는 횟수)가 홀수 번일 때, 뒤집는다.
            print("[" + ",".join(queue) + "]")
