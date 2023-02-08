#include <stdio.h>

int main(void) {
	int A, B, T;
	int i, j, gcd, lcm;  // gcd : 최대공약수  lcm : 최소공배수

	scanf("%d", &T);
	for (i = 0; i < T; i++) {
		scanf("%d %d", &A, &B);

		for (j = 1; j <= A && j <= B; ++j) {
			if (A % j == 0 && B % j == 0)
				gcd = j;
		}
		lcm = (A * B) / gcd;
		printf("%d\n", lcm);
	}
}