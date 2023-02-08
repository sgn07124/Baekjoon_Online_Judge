#include <stdio.h>

int main(void) {
	
	int m, n, i;
	int sum = 0;
	int min = 10000;
	
	scanf("%d", &m);
	scanf("%d", &n);

	for (i = m; i <= n; i++) {
		for (int j = 2; j <= i; j++) {
			if (i == j) {
				sum += i;
				if (i < min)
					min = i;
			}
			if (i % j == 0)
				break;
		}
	}

	if (sum > 0) {
		printf("%d\n", sum);
		printf("%d", min);
	}
	else
		printf("%d", -1);
}