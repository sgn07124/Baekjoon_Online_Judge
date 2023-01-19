n = int(input())

# dp 배열에 할당한 값
dp = [0] * (n+1)

# 최소값을 비교하기 위한 조건 3가지
# 1. dp[index] = dp[index//3]
# 2. dp[index] = dp[inxex//2]
# 3. dp[index] = dp[index-1] + 1
# => dp 배열에는 필요한 최소한의 값만 넣어두고 그 값을 기반으로 반복하여 n까지의 결과를 할당한다.

for i in range(2, n+1) :
    dp[i] = dp[i-1] + 1
    if i%2 == 0 :
        dp[i] = min(dp[i//2]+1, dp[i])
    if i%3 == 0 :
        dp[i] = min(dp[i//3]+1, dp[i])

# 반복문이 종료되면 dp의 (n+1)번째 값을 출력해준다.
print(dp[n])