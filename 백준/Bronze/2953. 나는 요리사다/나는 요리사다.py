max=0
min=0
count=1
count2=1
for i in range(1,6) :
    a, b, c, d = map(int, input().split())
    count=i
    min=a+b+c+d
    if max<min:
        max=min
        count2=count
print("%d %d" % (count2, max))