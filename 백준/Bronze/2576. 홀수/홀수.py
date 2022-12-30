sum = 0
min = 100
cnt = 0
for i in range(7) :
    num = int(input())
    if num%2==1 :
        if min > num :
            min = num
            cnt+=1
        sum += num

if (cnt>0) :
    print(sum)
    print(min)
else :
    print(-1)