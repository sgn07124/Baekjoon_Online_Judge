#include <stdio.h>

int main(void) {
	int N;
	scanf("%d", &N);

	int count = 0;
	int num = 666;
	
	while (1) {
		int consecutive = 0;  // consecutive : 연속되는 수
		int cur = num;   // cur에 num (666) 저장
		
		while (cur > 0) {  // cur 즉 num ( ) 이 0보다 크다면
			int digit = cur % 10;  // digit = cur(num)를 10으로 나눈 나머지
			if (digit == 6)
				consecutive++;  // cur을 10으로 나눈 나머지가 6이면 consecutive++
			else
				consecutive = 0;  // 다시 0으로 초기화

			if (consecutive == 3) {  // consecutive 가 3이 되면 count++를 하고 검사 종료
				count++;
				break;
			}
			cur = cur / 10;
		}
		// N번째로 작은 종말 숫자였다면 break, 아니라면 계속 진행
		if (count == N)
			break;
		num++;
	}
	printf("%d\n", num);
}