#include <stdio.h>

int main(void) {
	
	int king = 1, queen = 1, rook = 2, bishop = 2, knight = 2, pawn = 8;
	int kg, qn, rk, bp, kt, pn;

	scanf("%d %d %d %d %d %d", &kg, &qn, &rk, &bp, &kt, &pn);

	printf("%d %d %d %d %d %d", king - kg, queen - qn, rook - rk, bishop - bp, knight - kt, pawn - pn);
	
	return 0;
}