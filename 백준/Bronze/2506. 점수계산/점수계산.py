n = int(input())
cnt = 0
count=0
arr = list(map(int, input().split()))
for i in range (n) :
    if arr[i] == 1 :
        cnt+=1
        count+=cnt
    else :
        cnt=0
print(count)