#include <stdio.h>

int main(void)
{
	int n;
	int sum = 0;

	scanf("%d", &n);
	for (int i = n; i > 0; i--) {
		sum += i;
	}
	printf("%d", sum);
	
	return 0;
}