n = int(input())
cute = 0
nocute = 0
for i in range(n) :
    a = int(input())
    if a==0 :
        nocute=nocute+1
    else :
        cute=cute+1
if cute > nocute :
    print("Junhee is cute!")
else :
    print("Junhee is not cute!")