n = int(input())
data = list(map(int, input().split()))

data = sorted(data, reverse=False)
mid = len(data)//2
if len(data) % 2 == 0 :
    print(data[0] * data[-1])
elif len(data) == 1 :
    print(data[0]*data[0])
else :
    print(data[mid]*data[mid])