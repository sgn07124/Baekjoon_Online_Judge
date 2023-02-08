#include <stdio.h>

int main(void)
{
	int i = 1, j = 0;
	int N;

	scanf("%d", &N);
	for (i = 1; i <= N; i++)
	{
		for (j = 0; j < i; j++)
		{
			printf("*");
		}
		printf("\n");
	}
	return 0;
}