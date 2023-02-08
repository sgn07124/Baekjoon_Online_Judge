n = int(input())
for i in range(n) :
    p = int(input())
    li = {}
    for i in range(p) :
        a, b = input().split()
        li[int(a)] = b
    print(li.get(max(li.keys())))