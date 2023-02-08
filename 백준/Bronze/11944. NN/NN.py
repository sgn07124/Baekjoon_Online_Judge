N, M = map(int, input().split())
N_word = str(N)
NN = ''

while len(NN) < len(N_word) * N:
    NN += N_word
print(NN[:M])