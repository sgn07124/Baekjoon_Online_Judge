#include <stdio.h>

int main(void) {
	
	int num[3], i, j;
	int temp = 0;

	while (1) {
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

		if (num[0] == 0 && num[1] == 0 && num[2] == 0)
			break;
		else if (num[0] * num[0] == num[1] * num[1] + num[2] * num[2])
			printf("right\n");
		else
			printf("wrong\n");
	}
}