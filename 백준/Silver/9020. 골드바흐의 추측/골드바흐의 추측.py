import math

def is_prime(x) :
    for i in range(2, int(math.sqrt(x)) + 1) :
        if x % i == 0 :
            return False
    if x == 1 :
        return False
    return True

T = int(input())

for i in range(T) :
    n = int(input())
    for x in range(n // 2, 0, -1) :
        if is_prime(x) and is_prime(n-x) :
            print(x, n-x)
            break