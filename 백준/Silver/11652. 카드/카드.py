import sys
from collections import Counter

n = int(sys.stdin.readline())
list = []
for i in range(n) :
    list.append(int(sys.stdin.readline()))
list.sort()
data = Counter(list)
print(data.most_common(n=1)[0][0])