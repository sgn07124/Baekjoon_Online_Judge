#include <stdio.h>
#include <string.h>

int main(void)
{
	char word[1000000];
	int max, result = 0, len; // result : 가장 많이 쓰인 단어가 중복되었을 경우
	int cnt[26] = { 0, };  // 알파벳의 길이가 26이기 때문에 배열의 크기를 선언
	int select = 0;  // 가장 많이 쓰인 단어가 뭔지 저장하기 위한 변수를 선언
	int number;  // 배열의 값을 저장

	scanf("%s", word);
	len = strlen(word); // 시간초과를 대비하기위해 for문 밖의 len에 문자열의 길이를 저장

	for (int i = 0; i < len; i++) {
		if (word[i] >= 'A' && word[i] <= 'Z') {
			number = word[i] - 'A';
		}
		// arr[i] 가 대문자 A~Z 사이 일 경우에 아스키코드 값상 대문자 A를 빼주면 숫자 0~26
		//사이로 값이 나오기 때문에 그 값ㅇ르 number라는 변수에 넣어주었다
		else if (word[i] >= 'a' && word[i] <= 'z') {
			number = word[i] - 'a';
		}
		// 대문자와 같이 입력값이 소문자 a~z일 경우 소문자 a를 빼주면 숫자 0~26 사이의 값을
		// number라는 변수에 넣어준다
		cnt[number]++;
		// number에 저장된 정수값은 cnt[number]의 인덱스로 1만큼 더해준다.
		// 이렇게 해서 어떤 알파벳이 쓰였는지 하나하나씩 체크해준다
	}
	max = cnt[0];
	// max라는 변수 안에 가장 첫번째 인덱스 값을 넣어서 가장 많이 쓰인 알파벳을 찾는다
	for (int i = 0; i < 26; i++) {
		if (max < cnt[i]) {
			max = cnt[i];
			select = i;
		}
	}
	// select 변수 안에 cnt[i] 가 아니라 i로 넣어주는거 중요

	for (int i = 0; i < 26; i++) {
		if (max == cnt[i])
			result++;
		// 만약 max와 cnt[i] 값이 같다면 result에 1씩 더해서 가장 많이 스인 알파벳이
		// 2개 이상인지 찾아본다
	}
	if (result > 1)
		printf("?\n"); // 만약 2개 이상 많이 사용된 알파벳이 있다면 ? 출력
	else
		printf("%c", select + 'A');
	// 아니라면 아까 지정했던 select는 정수 값으로 지정되어 있어서 대문자 A 만큼 더해서
	// 출력해준다
	return 0;
}