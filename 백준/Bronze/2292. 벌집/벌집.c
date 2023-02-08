#include <stdio.h>
#include <string.h>

int main(void) {
	int n, x = 1, count = 1;

	scanf("%d", &n);

	while (1) {
		if (n - x <= 0)
			break;
		n -= x;
		x = count * 6;
		count++;
	}
	printf("%d\n", count);

	return 0;
}