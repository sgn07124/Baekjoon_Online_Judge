t = int(input())

for i in range(t) :
    n = int(input())
    max = 0
    maxname = ''
    for j in range(n) :
        name, liter = input().split()  # name : 학교 이름, liter : 술의 양
        liter = int(liter)  # 술의 양을 int형으로 변경
        if liter > max :
            max = liter
            maxname = name
    print(maxname)