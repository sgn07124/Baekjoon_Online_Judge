#include <stdio.h>

int main(void) {
	int i, n;
	int sum = 1;
	int count = 2;

	scanf("%d", &n);

	for (i = 9; i < n; i += 3) {
		sum += count;
		count += 1;
	}

	printf("%d", sum);

	return 0;
}