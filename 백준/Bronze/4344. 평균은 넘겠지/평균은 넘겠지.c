#include <stdio.h>

int main(void)
{
	int C = 0, N = 0; // C : 테스트의 개수  N : 학생 수
	scanf("%d", &C);

	for (int i = 0; i < C; i++) {
		scanf("%d", &N);  // score의 개수를 입력
		int score[1000], sum = 0;
		double avg = 0.00;
		for (int j = 0; j < N; j++) {  // 학생들 점수의 합을 구하는 과정
			scanf("%d", &score[j]);
			sum += score[j];
		}
		
		avg = (double)sum / N;
		int count = 0;
		for (int j = 0; j < N; j++) {
			if (avg < score[j]) // 평균보다 낮은 점수의 학생들을 카운트
				count++;
		}
		printf("%.3f%%\n", (double)count * 100 / N);  // {(평균보다 낮은 점수의 학생) / (학생수)} *100 = 비율
	}
	return 0;
}