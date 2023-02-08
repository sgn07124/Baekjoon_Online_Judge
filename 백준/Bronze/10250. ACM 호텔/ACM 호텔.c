#include <stdio.h>

int main(void) {
	
	int T, h, w, n;
	scanf("%d", &T);
	int count;

	for (int i = 0; i < T; i++) {
		count = 1;
		scanf("%d %d %d", &h, &w, &n);
		while (n > h) {
			n -= h;
			count++;
		}
		printf("%d%02d\n", n, count);
	}
	return 0;
}