#include <stdio.h>

int main() 
{
    int n;
    int fac = 1;
    scanf("%d", &n);
    
    for (int i = n; i > 0; i--) {
        fac *= i;
    }
    printf("%d", fac);

    return 0;
}