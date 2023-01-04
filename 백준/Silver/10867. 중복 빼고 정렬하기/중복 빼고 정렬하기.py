n = int(input())
data = []
data = list(map(int, input().split()))
data = list(set(data))  # set 자료구조 : 중복을 허용하지 않음
data.sort()

for i in data :
    print(i, end=' ')