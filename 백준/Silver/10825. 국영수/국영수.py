import sys
n = int(sys.stdin.readline())

data = []
for i in range(n) :
    data.append(list(map(str, sys.stdin.readline().split())))

data.sort(key=lambda x : str(x[0]))  #  4
data.sort(key=lambda x:int(x[3]), reverse=True)  # 3
data.sort(key = lambda x : int(x[2]))  # 2
data.sort(key = lambda x: int(x[1]), reverse = True)  # 1

for i in data :
    print(i[0])