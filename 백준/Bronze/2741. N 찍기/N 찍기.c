#include <stdio.h>

int main(void)
{
	int N, P;
	int i = 0;

	scanf("%d", &N);

	for (i = 1; i <= N; i++)
	{
		P = +i;
		printf("%d\n", P);
	}
	return 0;
}