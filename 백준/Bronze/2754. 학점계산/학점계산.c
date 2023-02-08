#include <stdio.h>

int main(void) {
	
	char score[10] = { "", };
	double sum = 0.0;

	scanf("%s", &score);

	if (score[0] == 'A')
		sum = 4;
	else if (score[0] == 'B')
		sum = 3;
	else if (score[0] == 'C')
		sum = 2;
	else if (score[0] == 'D')
		sum = 1;
	else if (score[0] == 'F')
		sum = 0.0;

	if (score[1] == '+')
		sum += 0.3;
	else if (score[1] == '-')
		sum -= 0.3;

	printf("%.1lf", sum);

}