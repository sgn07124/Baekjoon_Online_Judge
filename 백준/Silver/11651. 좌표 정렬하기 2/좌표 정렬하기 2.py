arr = []
n = int(input())

for i in range(n) :
    [a, b] = map(int,input().split())
    arr2 = [b, a]
    arr.append(arr2)
arr = sorted(arr)

for i in range(n) :
    print(arr[i][1], arr[i][0])