import sys
import math
n, k = map(int, sys.stdin.readline().split())
array = [True for i in range(n+1)]
cnt = 1

for i in range(2, n+1) :
    if array[i] == True :
        for j in range(i, n+1, i) :
            if array[j] == False :
                continue
            if cnt == k :
                print(j)
            array[j] = False
            cnt += 1
        