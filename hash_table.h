#ifndef HASH_TABLE_H_
#define HASH_TABLE_H_
#include "linked_list.h"

#define TRUE 1
#define FALSE 0

typedef struct HashTable{

  char* keys;
  LinkedList** values;
  
}HashTable;

HashTable* CreateHashTable();

void DestroyHashTable(HashTable** hash);

int Put(const char* string, HashTable* hash);

LinkedList* GetList(char key, HashTable* hash);

pthread_mutex_t* GetMutex(char key, HashTable* hash);

int GetIndex(char key);

#endif