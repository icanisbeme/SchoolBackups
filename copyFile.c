#include <stdio.h> // you need all the input/output

int main(int argc, char* argv[]){   //the parameters are needed for inputs from the user, in order to make the cp command
//first one is the command, second is the source, third is the destination file
//usage: copy_file <source_file> <destination>
if(argc != 3){
    printf("Usage: %s copy_file <source_file> <destination>\n", argv[0]);
    //user did not use command properly
    return 1;
}

//Source and destination filepaths.
char* source_filepath = argv[1];
char* destination_filepath = argv[2];
//open source file
FILE* source_file = fopen(source_filepath, "r");


if(source_file == NULL){
    printf("Could not open file %s\n", source_filepath);
    return 1;
}
//todo open file for writing
FILE* dest_file = fopen(destination_filepath, "w");
if(dest_file == NULL){
    printf("Could not open file %s\n", destination_filepath);
    fclose(source_file);
    return 1;
}


char line[512]; //buffer to store line
while(fgets(line, 512, source_filepath) != NULL){
    //TODO: copy line
    //1 string to write 2 file
    fputs(line, dest_file);
}

//close the file

fclose(source_file);
fclose(dest_file);

    return 0;
}
