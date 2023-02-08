arr = list(map(int, input().split()))

num = 1
while True :
    cnt = 0
    num += 1
    
    for i in arr :
        if num%i==0 :
            cnt += 1
    if cnt >= 3 :
        break
    
print(num)