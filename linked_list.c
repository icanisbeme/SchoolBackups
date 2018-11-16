#include <stdio.h>
#include "linked_list.h"
#include <stdlib.h>
#include <pthread.h>
#include <string.h>

StringNode* createStringNode(const char* string){
  StringNode* node = (StringNode*) malloc(sizeof(StringNode));
  if(node == NULL){
    free(node);
    return NULL;
  }

	node -> string = (char*) malloc(sizeof(char) * strlen(string));
strcpy(node-> string, string);
	node -> next = NULL;
return node;


}


LinkedList* CreateLinkedList(){

  LinkedList* listPtr = (LinkedList*) malloc(sizeof(LinkedList));
  if (listPtr == NULL){
    free(listPtr);
    return NULL;
  }

  listPtr -> front = NULL;
  pthread_mutex_init(&(listPtr -> mutex), NULL);
  return listPtr;
  
}

char* DestroyNode(LinkedList* linkedListPointer){
  if(linkedListPointer == NULL){
    return NULL;
  }
  if(linkedListPointer -> front == NULL){
    return NULL;
  }
  char* string = (char*) malloc(sizeof(char)*strlen(linkedListPointer->front->string));
  strcpy(string, linkedListPointer -> front -> string);
  StringNode* node = linkedListPointer -> front;

  linkedListPointer -> front  = node->next;
  node -> next = NULL;
  free(node);
  node = NULL;
  return string;
}

void DestroyLinkedList(LinkedList** linkedListPointer){
  if(linkedListPointer == NULL){
	pthread_mutex_destroy(&((*linkedListPointer)->mutex));
    return;
  }

  if((*linkedListPointer) -> front == NULL){
	pthread_mutex_destroy(&((*linkedListPointer)->mutex));
    free(*linkedListPointer);
    *linkedListPointer = NULL;
    return;
  }

  while(DestroyNode(*linkedListPointer) != NULL);
	pthread_mutex_destroy(&((*linkedListPointer)->mutex));
  free(*linkedListPointer);
  *linkedListPointer=NULL;
}


int Insert(const char* string, LinkedList* linkedListPointer){

  pthread_mutex_lock(&(linkedListPointer -> mutex));

  
  if(string == NULL || linkedListPointer == NULL){
    pthread_mutex_unlock(&(linkedListPointer -> mutex));
    return FALSE;
  }

  //empty list
  if(linkedListPointer -> front  == NULL){
    StringNode* node = createStringNode(string);
    linkedListPointer -> front = node;
    pthread_mutex_unlock(&(linkedListPointer -> mutex));
    return TRUE;
  }

  if(strcasecmp(string, linkedListPointer -> front -> string) <= -1){
    StringNode* node = createStringNode(string);
    node -> next = linkedListPointer -> front;
    linkedListPointer -> front = node;
    pthread_mutex_unlock(&(linkedListPointer -> mutex));
    return TRUE;
  }

  StringNode* node = createStringNode(string);
  StringNode* currentNode = linkedListPointer -> front;
  while((strcasecmp(node -> string, currentNode -> string)) >= 1 && currentNode -> next != NULL){
    currentNode = currentNode -> next;
  }

  if(currentNode -> next == NULL && strcasecmp(node -> string, currentNode -> string) == 0){
    pthread_mutex_unlock(&(linkedListPointer -> mutex));
    return FALSE;
  }

  if(currentNode -> next == NULL && (strcasecmp(node -> string, currentNode -> string)) >= 1){
    currentNode -> next = node;
    pthread_mutex_unlock(&(linkedListPointer -> mutex));
    return TRUE;
			      
  }
  if(currentNode -> next == NULL && strcasecmp(node -> string, currentNode -> string) == 0){
    pthread_mutex_unlock(&(linkedListPointer -> mutex));
    return FALSE;
  }
  
  StringNode* temp = currentNode -> next;
  currentNode -> next = node;
  node -> next = temp;
  pthread_mutex_unlock(&(linkedListPointer -> mutex));
  return TRUE;

}


int IsEmpty(const LinkedList* linkedListPointer){

  if(linkedListPointer == NULL){
    return TRUE;
  }
  if(linkedListPointer -> front == NULL){
    return TRUE;
  }
  return FALSE;
  
}
