#include <stdio.h>

int main(void) {
	int N, num[100], v;
	int i, j, count = 0;

	scanf("%d", &N);
	for (i = 0; i < N; i++)
		scanf("%d", &num[i]);
	
	scanf("%d", &v);

	for (i = 0; i < N; i++) {
		if (v == num[i])
			count++;
	}
	printf("%d", count);
}