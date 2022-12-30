n = int(input())

data = list(map(int, input().split()))
cnt = 0
for i in data :
    if i==n :
        cnt+=1
print(cnt)