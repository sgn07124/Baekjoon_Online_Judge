import sys
n = int(sys.stdin.readline())
arr = []
for i in range(n) :
    name, day, month, year = input().split()
    arr.append([name, int(day), int(month), int(year)])
arr = sorted(arr, key=lambda x: x[1])
arr = sorted(arr, key=lambda x: x[2])
arr = sorted(arr, key=lambda x: x[3])

print(arr[-1][0])
print(arr[0][0])