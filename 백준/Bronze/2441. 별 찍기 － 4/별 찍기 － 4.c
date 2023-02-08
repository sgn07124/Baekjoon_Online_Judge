#include <stdio.h>
int main(void)
{
    int i = 0, j = 0, k = 0, N;

    scanf("%d", &N);
    for (i = 0; i < N; i++)
    {
        for (k = 0; k < i; k++)
        {
            printf(" ");
        }
        for (j = 0; j < N - i; j++)
            printf("*");
        printf("\n");
    }
	
	return 0;
}