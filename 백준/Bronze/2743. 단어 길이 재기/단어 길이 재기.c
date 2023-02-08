#include <stdio.h>

int main(void) {
	
	char word[100];
	int size;

	scanf("%s", &word);
	for (int i = 0; i<=sizeof(word); i++) {
		if (word[i] == '\0')
			break;
	}
	size = strlen(word);

	printf("%d", size);
}