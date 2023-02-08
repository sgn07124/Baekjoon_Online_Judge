#include <stdio.h>
#include <string.h>
int main(void)
{
	int T, R;
	char S[20];

	scanf("%d", &T); // test case 의 개수 입력

	for (int i = 0; i < T; i++) {
		scanf("%d %s", &R, S);  // 반복 횟수, 문자열 입력
		for (int j = 0; j < strlen(S); j++) {  //  j를 문자열 개수만큼 반복
			for (int k = 0; k < R; k++) {
				printf("%c", S[j]);
			}
		}
		printf("\n");
	}
	return 0;
}