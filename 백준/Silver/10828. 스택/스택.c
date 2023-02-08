#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef struct {
    int data;
    struct Node *next;
} Node;

typedef struct {
    int count;
    Node *top;
} Stack;

void push(Stack *stack, int data) {
    Node *node = (Node*)malloc(sizeof(Node));
    node->data = data;
    node->next = stack->top;
    stack->top = node;
    stack->count++;
}

int pop(Stack *stack) {
    if(stack->count == 0) {
        return -1;
    } else {
        Node *node = stack->top;
        int data = node->data;
        stack->top = node->next;
        free(node);
        stack->count--;
        return data;
    }
}

int isEmpty(Stack *stack) {
    if(stack->count == 0) {
        return 1;
    } else {
        return 0;
    }
}

int top(Stack *stack) {
    if(stack->count == 0) {
        return -1;
    } else {
        return stack->top->data;
    }
}

int main(void) {
    int TestCase;
    scanf("%d", &TestCase);

    Stack s;
    s.top == NULL;
    s.count = 0;

    for(int i = 0; i < TestCase; i++) {
        char N[6];
        scanf("%s", N);
        if(!strcmp(N, "push")) {
            int data;
            scanf("%d", &data);
            push(&s, data);
        } else if(!strcmp(N, "pop")) {
            int data = pop(&s);
            printf("%d\n", data);
        } else if(!strcmp(N, "size")) {
            printf("%d\n", s.count);
        } else if(!strcmp(N, "empty")) {
            int data = isEmpty(&s);
            printf("%d\n", data);
        } else {
            int data = top(&s);
            printf("%d\n", data);
        }
    }

    return 0;
}