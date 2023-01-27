num = input()

for i in range(0, len(num), 10) :  # 0부터 len(num) 까지 10개씩 증가
    print(num[i:i+10])