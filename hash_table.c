#include "hash_table.h"
#include "linked_list.h"
#include <stdlib.h>
#include <stdio.h>
#include <pthread.h>
#include <string.h>

HashTable* CreateHashTable(){
  int i;
  HashTable* HashTablePointer = (HashTable*) malloc(sizeof(LinkedList));

  if (HashTablePointer == NULL){
    free(HashTablePointer);
    return NULL;
  }

  HashTablePointer -> keys = (char*) malloc(sizeof(char) * 26);
  if (HashTablePointer -> keys == NULL){
    free(HashTablePointer -> keys);
    return NULL;
  }

  HashTablePointer -> values = (LinkedList**) malloc(sizeof(LinkedList) * 26);

  if(HashTablePointer -> values == NULL){
    free(HashTablePointer -> values);
    return NULL;
  }

  for(int i = 0; i < 26; ++i){
    LinkedList* linkedList = CreateLinkedList();
    HashTablePointer -> values[i] = linkedList;
    HashTablePointer -> keys[i] = (65 + i);
  }
  
  return HashTablePointer;
}


void DestroyHashTable(HashTable** hashTable){
  if(hashTable == NULL){
    return;
  }


  free((*hashTable) -> values);

  (*hashTable) -> values = NULL;

  free((*hashTable) -> keys);

  (*hashTable) ->  keys = NULL;
  
  free(*hashTable);
  
  *hashTable = NULL;
}

int Put(const char* string, HashTable* hashTable){
  if(string == NULL || hashTable == NULL){
    return FALSE;
  }
  
  int index = GetIndex(*string);

  return Insert(string, hashTable -> values[index]);
}

LinkedList* GetList(char key, HashTable* hashTable){

  if(hashTable == NULL){
    return NULL;
  }

  int index = GetIndex(key);

  return (hashTable -> values[index]);
  
}

pthread_mutex_t* GetMutex(char key, HashTable* hashTable){
  if(hashTable == NULL){
    return NULL;
  }

  int index = GetIndex(key);

  return &(hashTable -> values[index] -> mutex);
  
}

int GetIndex(char key){
  int i;

   if( (key > 64 && key < 91) ){
    return key - 65;
  }else if( (key > 96 && key < 123) ){
    return key - 97;
  }else{
    return -1;
  }
}
