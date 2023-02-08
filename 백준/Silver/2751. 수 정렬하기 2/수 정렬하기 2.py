import sys

n = int(input())
li = []
for i in range(n) :
    li.append(int(sys.stdin.readline()))  # input() 내장 함수는 sys.stdin.readline()과 비교해서 prompt message를 출력하고, 개행 문자를 삭제한 값을 리턴하기 때문에 느리다.
li.sort()

for i in li :
    print(i)