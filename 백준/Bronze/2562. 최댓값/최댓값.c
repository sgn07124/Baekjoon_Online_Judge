#include <stdio.h>

int main(void)
{
	int N, max = 0, count = 0;

	for (int i = 1; i <= 9; i++) {
		scanf("%d", &N);
		if (N > max) {
			max = N;
			count = i;
		}
	}
	printf("%d\n%d\n", max, count);

	return 0;
}