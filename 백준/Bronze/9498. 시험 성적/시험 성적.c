#include <stdio.h>
int main(void)
{
    int score;
    scanf("%d", &score);
    
    if((90<=score)&&(100>=score))
        printf("A");
    else if((80<=score)&&(89>=score))
        printf("B");
    else if((70<=score)&&(79>=score))
        printf("C");
    else if((60<=score)&&(69>=score))
        printf("D");
    else
        printf("F");
    
    return 0;
}