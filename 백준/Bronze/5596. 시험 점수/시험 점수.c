#include <stdio.h>

int main(void)
{
	int info1, math1, science1, eng1, info2, math2, science2, eng2, S, T;
	scanf("%d %d %d %d\n", &info1, &math1, &science1, &eng1);
	scanf("%d %d %d %d", &info2, &math2, &science2, &eng2);

	S = info1 + math1 + science1 + eng1;
	T = info2 + math2 + science2 + eng2;

	if (S > T)
		printf("%d", S);
	else if (S < T)
		printf("%d", T);
	else
		printf("%d", S);

	return 0;
}