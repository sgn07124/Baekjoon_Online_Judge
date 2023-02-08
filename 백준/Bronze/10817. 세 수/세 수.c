#include <stdio.h>

int main(void) {
	int num[3];
	int i, j, temp = 0;

	for (i = 0; i < 3; i++) {
		scanf("%d", &num[i]);
	}
	for (i = 0; i < 3; i++) {
		for (j = i; j < 3; j++) {
			if (num[i] < num[j]) {
				temp = num[i];
				num[i] = num[j];
				num[j] = temp;
			}
		}
	}
	printf("%d", num[1]);

}