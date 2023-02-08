#include <stdio.h>

int main(void) {
	
	int num, i, n, sum = 0;

	for (i = 0; i < 5; i++) {
		scanf("%d", &num);
		sum += num * num;
	}
	n = sum % 10;

	printf("%d", n);

}