import sys
from collections import Counter

data = []
for i in range(10) :
    data.append(int(sys.stdin.readline()))
print(sum(data)//10)

cnt = Counter(data)  # 최빈값 구하기
mode = cnt.most_common()
print(mode[0][0])