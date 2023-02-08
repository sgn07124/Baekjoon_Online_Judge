#include <stdio.h>

int main(void) {
	int total, num, price, n;
	int sum = 0;

	scanf("%d", &total);

	scanf("%d", &num);

	for (int i = 0; i < num; i++) {
		scanf("%d %d", &price, &n);
		sum += (price * n);
	}

	if (total == sum) {
		printf("Yes");
	}
	else
		printf("No");
}