import sys
n = int(sys.stdin.readline())
arr = []
for i in range(n) :
    name, day, month, year = input().split()
    arr.append([name, int(day), int(month), int(year)])
arr = sorted(arr, key=lambda x: x[1])
arr = sorted(arr, key=lambda x: x[2])
arr = sorted(arr, key=lambda x: x[3])

# [['jerry', 18, 9, 1990], ['gar', 20, 9, 1990], ['alice', 30, 12, 1990], ['micky', 1, 10, 1991], ['tom', 15, 8, 1993]]
# day -> month -> year 순서대로 sorted가 되어 결론적으로는 year이 마지막으로 정렬됨.

print(arr[-1][0])
print(arr[0][0])
