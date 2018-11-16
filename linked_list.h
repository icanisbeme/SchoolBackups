#ifndef LINKED_LIST_H_
#define LINKED_LIST_H_
#include <pthread.h>
#define TRUE 1
#define FALSE 0

typedef struct StringNode{
  char* string;
  struct StringNode* next;
}StringNode;

typedef struct LinkedList{
  StringNode* front;
  pthread_mutex_t mutex;
}LinkedList;

LinkedList* CreateLinkedList();

void DestroyLinkedList(LinkedList** linkedListPtr);

int Insert(const char* string, LinkedList* linkedListPtr);

int IsEmpty(const LinkedList* linkedListPtr);

#endif
