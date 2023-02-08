#include <stdio.h>
int main (void)
{
    int i = 1;
	int N, R;
	
	scanf("%d", &N);

	for (i = 1; i < 10; i++)
	{
		R = N * i;
		printf("%d * %d = %d\n", N, i, R);
	}

	return 0;
}