test = int(input())
for i in range(test) :
    s = int(input())
    n = int(input())
    sum = 0
    for i in range(n) :
        a, b = map(int, input().split())
        sum = sum + a*b
    print(sum+s)