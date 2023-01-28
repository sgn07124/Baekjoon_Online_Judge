k = int(input())

for i in range(k):

    data = list(map(int, input().split()))
    del data[0]
    data.sort()
    result = []
    print('Class', i+1)
    for i in range(len(data)-1):
        result.append(data[i+1] - data[i])

    print('Max', str(max(data))+',' ,'Min', str(min(data))+',', 'Largest gap', max(result))