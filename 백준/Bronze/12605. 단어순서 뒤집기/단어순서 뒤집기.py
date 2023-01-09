n = int(input())

for i in range(n) :
    data = list(input().split())
    data = data[::-1]
    arr = ' '.join(s for s in data)
    print("Case #{0}:".format(i+1), arr)