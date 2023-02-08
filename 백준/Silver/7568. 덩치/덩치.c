#include <stdio.h>

int main(void) {
	int N, i, j, count;
	int arr[50][2];  // N의 최댓값이 50이고 키와 몸무게 이렇게 2개를 입력하기 때문

	scanf("%d", &N);

	// 키와 몸무게를 입력
	for (i = 0; i < N; i++)
		scanf("%d %d", &arr[i][0], &arr[i][1]);

	for (i = 0; i < N; i++) {
		count = 0;
		for (j = 0; j < N; j++) {
			if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1])
				count++;
		}
		printf("%d ", ++count);
	}
	return 0;
}