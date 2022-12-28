n, k = map(int, input().split())
arr = []
cnt = 0

for i in range(n) :
    arr.append(int(input()))

arr.sort(reverse=True)

for i in arr :
    if k >= i :
        cnt += k // i
        k = k % i

print(cnt)