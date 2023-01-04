from collections import deque
import sys

d = deque()
n = int(input())

for i in range(n) :
    command = sys.stdin.readline().split()

    if command[0] == "push_front" :
        d.appendleft(command[1])
    elif command[0] == "push_back" :
        d.append(command[1])
    elif command[0] == "pop_front" :
        if d :
            print(d[0])  # 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력
            d.popleft()
        else :
            print("-1")
    elif command[0] == "pop_back" :
        if d :
            print(d[-1])  # 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력
            d.pop()
        else :
            print("-1")
    elif command[0] == "size" :
        print(len(d))
    elif command[0] == "empty" :
        if d :
            print("0")
        else :
            print("1")
    elif command[0] == "front" :
        if d :
            print(d[0])
        else :
            print("-1")
    elif command[0] == "back" :
        if d :
            print(d[-1])
        else :
            print("-1")