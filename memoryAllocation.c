#include <stdio.h>
#include <stdlib.h>

//if you want to be tighter on memory, here is a way to allocate necessary memory
int main(){
    //malloc.
    //if you want to store a string
    char* string;
    string = (char*) malloc(50*sizeof(char)); //allocates memory for 50 chars
    //the char* says that everything is going to be stored as chars
    //this memory is allocated in the *heap*
    // malloc returns a void* which is a generic pointer 

    if(string == NULL){ //this means we did not allocate memory successfully
        fprintf(stderr, "Could not allocate memory\n");
        return 1;
    }
    //String with 50 chars -
    char* hello_str = "hello";
    //memory that you want to copy to, the source of what you want to copy, the number of characters (six because length of string + terminating character)
    memcpy(string, hello_str, 6) sizeof(char));

    puts(string);   

    //release the memory
    free(string);//says we don't need that memory anymore, and the OS takes care of it
    //you can't use this memory block after freeing it
    //string still has the address of the memory that was allocated previously, so it may not be available anymore 
    string = NULL; //this ensures that the pointer is now pointing to nothing and is effectively voided


//if you forget to free memory, that is called a memory leak. common error. identifying the error is hard, so rule of them
//always free the memory, and reset it to null
//memory leaks can slow down the entirity of the computer

    return 0;
}