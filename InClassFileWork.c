#include <stdio.h>

int main(int argc, char* argv[]){
	if(argc != 2){
		printf("Usage: %s <file to open>>\n", arg[0]);
	}
	//reporting a bad finish
	return 1;
}

char* input_file = argv[1];
//reports the exit status to the OS
//second argument: r:read the file, w: writing: rw:read and write         add b to make it binary (rb)

FILE* file_to_open = fopen(input_file, "r");	
if (file_to_open == NULL){
	printf("Unable to open file %s\n", input_file);
	return 1;
}

//i have opened file
//todo: read the file
//close the file

fclose(file_to_open);
return 0;
}

//test cases
//ask to read a file that doesn't exist


//we have opened the file
//reade the file
char line[100];

//EOF = end of file. idea is to keep reading until we reach EOF, which that case fgets() returns NULL
while(fgets(line, 100, file_to_open) != NULL){
	puts(line);
}

//did i reaech the end of file
if(feof(file_to_open)){
	
}

 //puts puts a new line whenever it writes
//close the file
fclose(file_to_open);
return 0;
