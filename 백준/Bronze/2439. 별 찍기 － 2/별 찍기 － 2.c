#include <stdio.h>

int main(void)
{
	int i = 0, j = 0, k = 0;
	int N;

	scanf("%d", &N);
	for (i = 1; i <= N; i++)
	{
		for (k = 1; k <= (N - i); k++)
		{
			printf(" ");
		}
		for (j = 1; j <= i; j++)
		{
			printf("*");
		}
		printf("\n");
	}
	return 0;
}