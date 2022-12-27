n = int(input())

arr = input()
cnta = 0
cntb = 0
for i in range(n) :
    if arr[i] == 'A' :
        cnta = cnta + 1
    elif arr[i] == 'B' :
        cntb = cntb + 1

if cnta > cntb :
    print('A')
elif cnta < cntb :
    print('B')
else :
    print('Tie')