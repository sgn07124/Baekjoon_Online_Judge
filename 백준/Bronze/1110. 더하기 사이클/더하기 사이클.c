#include <stdio.h>

int main(void)
{
	int a, b, c, d=-1;
	int result, input, count = 0;

	scanf("%d", &input);
	result = input;  // 원래의 input값을 미리 저장

	while (d != result) {
		a = input / 10; // 십의 자리 수
		b = input % 10; // 일의 자리 수 -> 주어진 수의 가장 오른쪽 자리 수
		c = (a + b) % 10; // 각 자리 수를 더한 값의 가장 오른쪽 자리 수
		d = b * 10 + c;  // 원래의 수의 가장 오른쪽 자리 수와 c의 가장 오른쪽 자리 수를 합한 값 -> 새로운 수
		input = d;  // 새로운 수 d를 input에 넣어 반복
		count++; // 반복한 횟수(사이클의 길이)를 카운트
	}
	printf("%d", count);

	return 0;
}