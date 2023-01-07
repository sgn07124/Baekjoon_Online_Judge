from collections import Counter
import sys

n = int(sys.stdin.readline())
data = []

for i in range(n) :
    data.append(int(sys.stdin.readline()))

# 산술 평균
avg = sum(data)/len(data)
print(round(avg))

# 중앙값
data.sort()
print(data[int((n-1)/2)])

# 최빈값
c = Counter(data).most_common(2)  # data의 요소들의 숫자를 센 Dictionary 자료형의 빈도수가 높은 숫자 2개 선택
if len(data) > 1 :
    if c[0][1] == c[1][1] :  # 만약 첫번째와 두번째의 빈도수가 같다면,
        print(c[1][0])  # 두번째 빈도수의 값 출력
    else :
        print(c[0][0])
else :
    print(c[0][0])

# 범위
print(max(data)-min(data))