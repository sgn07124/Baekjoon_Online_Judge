#include <stdio.h>
#include <string.h>

int main(void) {
	char arr[100];
	int i, sum;

	scanf("%s", arr);

	sum = strlen(arr);
	for (i = 0; i < strlen(arr); i++) {
		if ((arr[i] == 'l' || arr[i] == 'n') && arr[i + 1] == 'j')
			sum--;
		if (arr[i] == 'd' && arr[i + 1] == 'z' && arr[i + 2] == '=')
			sum--;
		if (arr[i] == '=' || arr[i] == '-')
			sum--;
	}
	printf("%d", sum);
}