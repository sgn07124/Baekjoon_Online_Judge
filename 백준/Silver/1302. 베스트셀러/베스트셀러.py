import sys
from collections import Counter
n = int(sys.stdin.readline())
list = []

for i in range(n) :
    list.append(sys.stdin.readline())
list.sort()
data = Counter(list)
print(data.most_common(n=1)[0][0])  # 가장 많은 개수의 데이터의 key 출력