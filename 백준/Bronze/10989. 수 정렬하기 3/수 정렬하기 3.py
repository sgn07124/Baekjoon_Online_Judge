import sys

n = int(sys.stdin.readline())
data = [0] * 10001  # 입력값이 극한으로 많이 주어질 때에는 메모리를 더 효율적으로 관리하기 위해서 10000개의 리스트를 만든다.

for _ in range(n) :
    data[int(sys.stdin.readline())] += 1  # 리스트에 각 요소마다 0을 할당해놓고 입력값을 받을 때마다 그 입력값과 같은 인덱스에 +1씩 해준다.

for i in range(10001) :
    if data[i] != 0 :  # 0보다 큰 요소를 갖는 인덱스들을 찾아서 그 수만큼 인덱스를 출력한다.
        for j in range(data[i]) :
            print(i)