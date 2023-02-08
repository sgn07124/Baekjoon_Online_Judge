#include <stdio.h>
void Yogurt()
{
    int i, j;
    int N;
    int cnt;
    for (i = 0;i < 3;i++)
    {
        cnt = 0;
        for (j = 0;j < 4;j++)
        {
            scanf("%d", &N);
            if (N == 0)
                cnt++;
        }
        if (cnt == 0)
            printf("E\n");
        else if (cnt == 1)
            printf("A\n");
        else if (cnt == 2)
            printf("B\n");
        else if (cnt == 3)
            printf("C\n");
        else
            printf("D\n");
    }
}
int main()
{
    Yogurt();
}