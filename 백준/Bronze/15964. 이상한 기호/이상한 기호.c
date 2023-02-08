#include <stdio.h>

int main(void) {
	int A, B, result;

	scanf("%d %d", &A, &B);

	result = (A + B) * (A - B);

	printf("%d", result);
}