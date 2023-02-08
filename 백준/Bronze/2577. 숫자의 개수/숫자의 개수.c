#include <stdio.h>

int main(void)
{
	int a, b, c;
	int arr[10] = { 0, }; // 배열의 요소를 모두 0으로 초기화
	scanf("%d %d %d", &a, &b, &c);
	int m = a * b * c; //m = 곱

	int num;
	while (m > 0) {
		num = m % 10; // 정수를 자리수에 따라 쪼개야 할 때는 10으로 나눗셈/나머지연산 하면 간단히 처리 가능
		arr[num]++; //while문에서 값을 새로 할당하는 것이 아니라 원래 값을 증가시키기 때문에(증감 연산자 사용)
                    //선언할 때 0으로 초기화를 해두어야한다
		m /= 10;
	}

	for (int i = 0; i < 10; i++) {
		printf("%d\n", arr[i]);
	}

	return 0;
}