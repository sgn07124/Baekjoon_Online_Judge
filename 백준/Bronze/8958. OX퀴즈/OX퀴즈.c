#include <stdio.h>
#include <string.h> // strlen()함수 : 문자열의 길이를 반환하는 함수(#include <string.h> 헤더파일 필요)

int main(void)
{
	int input, score, sum; 
								  
	char test[80];

	scanf("%d", &input); // scanf로 테스트 케이스 개수 input을 받는다

	for (int i = 0; i < input; i++) {
		sum = 0; // sum을 0으로 초기화(for문이 끝나면 새로운 OX문을 세야되기 때문)
		score = 1; // score을 1으로 초기화 (연속적인 O로 마무리 시 점수가 1보다 큰값으로 마무리 되기 때문)
		scanf("%s", test); //OX를 입력받음
		for (int j = 0; j < strlen(test); j++) { // strlen(test) ( OX의 총 갯수) 만큼 O와 X를 세어준다 (test의 길이)
			if (test[j] == 'O') {
				sum += score; // 점수를 더해줌
				score++;  // 점수를 올려줌
			}
			if (test[j] == 'X')  
				score = 1;  // 연속적인 O가 끝났으므로 score = 1로 초기화
		}
		printf("%d\n", sum);
	}
    return 0;
}