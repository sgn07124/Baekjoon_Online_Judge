import sys

max_num = 0
x=0
y=0

for i in range(9) :
    row = list(map(int, sys.stdin.readline().split()))
    if max(row) > max_num :
        max_num = max(row)
        x = i
        y = row.index(max_num)
print(max_num)
print(x+1, y+1)