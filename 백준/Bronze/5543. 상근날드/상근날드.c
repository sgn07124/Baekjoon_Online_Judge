#include <stdio.h>

int main(void) {
	int menu[5], sum;
	int i, burmin = 2000, drimin = 2000;

	for (i = 0; i < 5; i++) {
		scanf("%d", &menu[i]);
	}
	for (i = 0; i < 3; i++) {
		if (burmin > menu[i]) {
			burmin = menu[i];
		}
	}
	for (i = 3; i < 5; i++) {
		if (drimin > menu[i])
			drimin = menu[i];
	}
	sum = (burmin + drimin) - 50;

	printf("%d", sum);

}