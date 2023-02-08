#include <stdio.h>

int main(void)
{
	int A, B, C, re;

	scanf("%d %d", &A, &B);
	scanf("%d", &C);

	B = B + C;
	if (B > 59) { // B가 59분 이상이라면
		re = B / 60;   // re에 B를 60으로 나눈 몫 즉 시간을 저장
		B = B % 60;  // B에 B를 60으로 나눈 나머지 즉 분을 저장
		A += re;  // 시간에 re에 저장된 시간을 더해서 A에 저장
		if (A > 23) {
			A = A % 24;
		}
	}
	printf("%d %d", A, B);

	return 0;
}