t = int(input())
for i in range(t) :
    sa=0
    sb=0
    for i in range(9) :
        a, b = map(int, input().split())
        sa=sa+a
        sb=sb+b
    if sa>sb :
        print("Yonsei")
        
    elif sa<sb :
        print("korea")
    else :
        print("Draw")