#include <stdio.h>

int main(void)
{
	int x = 0, y = 0;
	int school, pc, academi, home, total;

	scanf("%d\n %d\n %d\n %d", &school, &pc, &academi, &home);

	total = school + pc + academi + home;

	x = total / 60;
	y = total % 60;

	printf("%d\n", x);
	printf("%d", y);


	return 0;
}