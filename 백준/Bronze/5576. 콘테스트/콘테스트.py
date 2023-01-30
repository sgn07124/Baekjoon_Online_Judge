import sys
w = []
k = []
for i in range(10) :
    w.append(int(sys.stdin.readline()))
for i in range(10) :
    k.append(int(sys.stdin.readline()))
w.sort()
k.sort()
W = w[9] + w[8] + w[7]
K = k[9] + k[8] + k[7]

print(W, K)