#include <stdio.h>

int main(void)
{
	int num1 = 0, num2 = 0;
	int ans1, ans2, ans3, ans4;

	scanf("%d\n %d", &num1, &num2);

	ans1 = num1 * (num2 % 10);
	ans2 = num1 * ((num2 % 100) / 10);
	ans3 = num1 * (num2 / 100);
	ans4 = ans1 + ans2*10 + ans3*100;

	printf("%d\n", ans1);
	printf("%d\n", ans2);
	printf("%d\n", ans3);
	printf("%d\n", ans4);

	return 0;
}