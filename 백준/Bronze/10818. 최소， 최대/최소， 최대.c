#include <stdio.h>

int main(void)
{
	int N, num;
	int max = -1000000;
	int min = 1000000;

	scanf("%d", &N);

	for (int i = 0; i < N; i++) {
		scanf("%d", &num);
		if (num > max)
			max = num;
		if(num < min)
			min = num;
	}
	printf("%d %d", min, max);

	return 0;
}