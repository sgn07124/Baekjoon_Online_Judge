# [Bronze V] 행렬 덧셈 - 2738 

[문제 링크](https://www.acmicpc.net/problem/2738) 

### 성능 요약

메모리: 30748 KB, 시간: 48 ms

### 분류

구현(implementation), 수학(math)

### 문제 설명

<p>N*M크기의 두 행렬 A와 B가 주어졌을 때, 두 행렬을 더하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 행렬의 크기 N 과 M이 주어진다. 둘째 줄부터 N개의 줄에 행렬 A의 원소 M개가 차례대로 주어진다. 이어서 N개의 줄에 행렬 B의 원소 M개가 차례대로 주어진다. N과 M은 100보다 작거나 같고, 행렬의 원소는 절댓값이 100보다 작거나 같은 정수이다.</p>

### 출력 

 <p>첫째 줄부터 N개의 줄에 행렬 A와 B를 더한 행렬을 출력한다. 행렬의 각 원소는 공백으로 구분한다.</p>

<br>
<br>

### 런타임 에러 (결과는 맞게 나옴)
```python
import sys

n, p = map(int, sys.stdin.readline().split())

A, B = [], []

for row in range(n) :
    row = list(map(int, sys.stdin.readline().split()))
    A.append(row)

for row in range(p) :
    row = list(map(int, sys.stdin.readline().split()))
    B.append(row)

for row in range(n) :
    for col in range(p) :
        print(A[row][col] + B[row][col], end=' ')
    print()
```
