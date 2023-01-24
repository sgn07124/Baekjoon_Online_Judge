import sys

n = int(sys.stdin.readline())

a = list(map(int, sys.stdin.readline().split()))
b = list(map(int, sys.stdin.readline().split()))

total = 0
a.sort() # 오름차순

for i in range(n) :
    x = a[i]
    y = b.pop(b.index(max(b)))  # b는 재정렬하면 안되니 pop()을 이용해서 최댓값부터 뽑아낸다.

    total += x * y

print(total)