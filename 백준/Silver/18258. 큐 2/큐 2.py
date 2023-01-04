from collections import deque
import sys

n = int(input())
q = deque()

for i in range(n) :
    command = sys.stdin.readline().split()

    if command[0] == "push" :
        q.appendleft(command[1])
    if command[0] == "pop" :
        if q :
            print(q[-1])
            q.pop()
        else :
            print("-1")
    if command[0] == "size" :
        print(len(q))
    if command[0] == "empty" :
        if q :
            print("0")
        else :
            print("1")
    if command[0] == "front" :
        if q :
            print(q[-1])
        else :
            print("-1")
    if command[0] == "back" :
        if q :
            print(q[0])
        else :
            print("-1")