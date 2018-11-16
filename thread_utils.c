#include "thread_utils.h"
#include "linked_list.h"
#include <stdlib.h>
#include <stdio.h>
#include <pthread.h>
#include <string.h>
#include "hash_table.h"

void* BuildDictionaryFromFiles(void* arguments){
  if(arguments == NULL){
    return NULL;
  }

  FILE* file;

  char* stringToAdd = (char*) malloc(sizeof(char) * 513);

  if(stringToAdd == NULL){
    return NULL;
  }

  JobArguments* jobArguments = (JobArguments*) arguments;

  for(int i = jobArguments -> start_index; i < jobArguments -> end_index; i++){
    file = fopen(jobArguments -> filepaths[i], "r");
    if(file == NULL){
      free(stringToAdd);
      return NULL;
    }

     while(fscanf(file, "%512s", stringToAdd) == 1){
	 Put(stringToAdd, jobArguments -> hash_table);
	
     }

     fclose(file);
  }

  free(stringToAdd);
  stringToAdd = NULL;
  pthread_exit(NULL);
  
  
}

void CreateOutputFile(HashTable* hash, char* filepath){

  if(hash == NULL || filepath == NULL){
     return;
  }

  LinkedList* linkedList = NULL;

  FILE *file;

  file = fopen(filepath, "w");
  if(file == NULL){
    return;
  }

  for(int i = 0; i < 26; ++i){

    pthread_mutex_t* mutex = GetMutex((char)('a' + i) , hash);

    pthread_mutex_lock(mutex);

    linkedList = GetList((char)('a' + i), hash);

    StringNode* currentNode = linkedList -> front;

    while(currentNode != NULL){
      fprintf(file, "%s ", currentNode -> string);
      currentNode = currentNode -> next;
    }
    pthread_mutex_unlock(mutex);
    
  }
  fclose(file);
  
}



HashTable* ProcessFiles(int numThreads, const char** strings, int numFiles){

  if(strings == NULL || numThreads < 1 || numFiles < 1){
    return NULL;
  }

  int filePerThread = numFiles / numThreads;
  pthread_t workers[numThreads];
  HashTable* hash = CreateHashTable();
  JobArguments arguments[numThreads];


  pthread_attr_t attributes;

  pthread_attr_setdetachstate(&attributes, PTHREAD_CREATE_JOINABLE);

  for(int i = 0; i < numThreads; i++){
    arguments[i].hash_table = hash;
    arguments[i].filepaths = (char**) strings;
    arguments[i].start_index = i * filePerThread;
    arguments[i].end_index = (i + 1) * filePerThread - 1;
    pthread_create(&workers[i], &attributes, BuildDictionaryFromFiles, &arguments[i]);
  }

  for(int i = 0; i < numThreads; ++i){
    pthread_join(workers[i], NULL);
  }

  return hash;
  
}
