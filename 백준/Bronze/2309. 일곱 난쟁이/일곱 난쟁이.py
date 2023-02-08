arr = []

for i in range(9) :
    arr.append(int(input()))

su = sum(arr)
a1 = 0
a2 = 0

for i in range(8) :
    for j in range(i+1, 9) :
        if su - (arr[i]+arr[j]) == 100 :
            aa = arr[i]
            bb = arr[j]
            
arr.remove(aa)
arr.remove(bb)

arr.sort()

for i in range(7) :
    print(arr[i])