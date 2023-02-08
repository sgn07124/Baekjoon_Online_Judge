a, b = map(int, input().split())

arr = [0]

for i in range(b+1) :
    for j in range(i) :
        arr.append(i)
        
print(sum(arr[a:b+1]))