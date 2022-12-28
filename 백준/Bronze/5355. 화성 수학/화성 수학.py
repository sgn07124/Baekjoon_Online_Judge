t = int(input())
arr = []

for i in range(t) :
    arr = list(input().split())
    num = float(arr.pop(0))   # arr의 0번째 인덱스를 pop하여 실수형으로 num에 저장
    for j in range(len(arr)) :
        if arr[j] == '@' :
            num *= 3
        elif arr[j] == '%' :
            num += 5
        elif arr[j] == '#' :
            num -= 7
    print("%0.2f" % num)