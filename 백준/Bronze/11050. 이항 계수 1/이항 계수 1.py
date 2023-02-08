from math import factorial as fact

a, b = map(int, input().split())

print(fact(a)//fact(b)//fact(a-b))