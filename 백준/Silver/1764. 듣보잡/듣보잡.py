import sys
from collections import Counter

n, m = map(int, sys.stdin.readline().split())
N = set()  # set() 자료형 : 리스트 내 중복을 허용하지 않음
M = set()
for i in range(n) :  #  n : 듣도 못한 사람
    N.add(sys.stdin.readline())  # set()의 특성을 활용해서 입력받은 문자들을 add()해야 함
for j in range(m) :  #  m : 보도 못한 사람
    M.add(sys.stdin.readline())

result = sorted(list(N&M))  #  & : 교집합

print(len(result))
for i in result :
    print(i, end='')