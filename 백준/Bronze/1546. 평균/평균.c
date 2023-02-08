#include <stdio.h>

int main(void)
{
	int n, score, max = 0;
    double sum = 0;

	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		scanf("%d", &score);
		sum += score;
		if (score > max)
			max = score;
	}
	

	printf("%lf", (sum/max*100)/n);

	return 0;
}