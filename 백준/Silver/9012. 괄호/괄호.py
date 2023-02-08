n = int(input())

for i in range(n) :
    a = list(input())
    cnt = 0
    for j in a :
        if j == '(' :
            cnt += 1
        elif j == ')' :
            cnt -= 1
        if cnt < 0 :
            break
    if cnt == 0 :
        print('YES')
    else :
        print('NO')