#include <stdio.h>

int main(void)
{
	int A, B, T;
	int i = 0, C = 1;

	scanf("%d", &T);

	for (i = 0; i < T; i++)
	{
		C = i+1;
		scanf("%d %d", &A, &B);
		printf("Case #%d: %d + %d = %d\n", C, A, B, A + B);
	}
	return 0;
}