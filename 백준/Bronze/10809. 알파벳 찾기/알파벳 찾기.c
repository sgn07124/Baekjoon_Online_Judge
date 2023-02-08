#include <stdio.h>
int main(void)
{
	char S[100] = {0};
	
	scanf("%s", S);

	for (int i = 97; i <= 122; i++) { //아스키코드 a~z를 반복
		int j = 0;
		while (S[j] != 0) {
			if (S[j] == (char)i) {
				break;
			}
			j++; //j는 0부터 증가 
		}
		if (S[j] == (char)i)
			printf("%d ", j);
		else
			printf("-1 ");
	}
	return 0;
}