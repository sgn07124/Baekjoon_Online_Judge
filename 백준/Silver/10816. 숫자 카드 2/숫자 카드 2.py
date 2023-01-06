from sys import stdin
from collections import Counter

_ = stdin.readline()
N = stdin.readline().split()
_ = stdin.readline()
M = stdin.readline().split()

C = Counter(N)  # 리스트 N을 Counter에 넣으면 N의 요소들의 숫자를 센 Dictionary 자료형이 출력된다.
print(' '.join(f'{C[m]}' if m in C else '0' for m in M))
# Counter(n)에 M의 요소가 있다면 해당 숫자를 출력하고 없으면 0을 출력한다.