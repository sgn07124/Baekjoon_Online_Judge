#include <stdio.h>
 
int main()
{
    int youngest, middle;
    
    scanf("%d %d", &youngest, &middle);
    
    printf("%d\n", middle + (middle-youngest));
 
    return 0;
}


