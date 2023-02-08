from sys import stdin

n = int(stdin.readline())

queue = []

for i in range(n) :
    a = stdin.readline().split()
    
    if a[0] == 'push' :
        queue.append(a[1])
    elif a[0] == 'pop' :
        if queue :
            print(queue.pop(0))
        else :
            print(-1)
    elif a[0] == 'size' :
        print(len(queue))
    elif a[0] == 'empty' :
        if len(queue) == 0 :
            print(1)
        else :
            print(0)
    elif a[0] == 'front' :
        if len(queue) > 0 :
            print(queue[0])
        else :
            print(-1)
    elif a[0] == 'back' :
        if len(queue) > 0 :
            print(queue[-1])
        else :
            print(-1)