#ifndef THREAD_UTILS_H_
#define THREAD_UTILS_H_
#include "hash_table.h"


typedef struct JobArguments{
  HashTable* hash_table;
  char** filepaths;
  int start_index;
  int end_index;
}JobArguments;

void* BuildDictionaryFromFiles(void* arguments);

void CreateOutputFile(HashTable* hash, char* filepath);

HashTable* ProcessFiles(int numThreads, const char** strings, int numFiles);

#endif