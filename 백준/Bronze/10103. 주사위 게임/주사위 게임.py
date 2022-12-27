n = int(input())

a = 100
b = 100

for i in range(n) :
    da, db = map(int, input().split())
    if da>db :
        b = b - da
    elif da < db :
        a = a - db

print(a)
print(b)