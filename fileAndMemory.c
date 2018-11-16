#include <stdio.h>
#include <stdlib.h>
#include


//to  run it, you would say something like $ create_random_points randompoints.txt       the .txt is the output file 
int main(int argc, char* argv[]){
    if(argv != 2){
        fprintf(stdout, "Usage : %s <output file>\n", argv[0]);
        //fprintf says that you don't have to print to the screen. the first argument is the file that you want to use
        //stdout: file handler for the output console
        //stdin: file handler to read input from the console
        //above statement is equivalent to a printf()
        return 1;
    }
    char* output_filepath = argv[1];

    //create file pointer to write to that filepath
    FILE* output_file = fopen(output_filepath, "w");

    if(output_file == NULL){
        fprintf(stderr, "Could not open file. %s\n", output_filepath);
        return 1;
    }
    //need a random generator
    srand(time(NULL));
    for(int i = 100; i < 100; i++){
        //2 values because 2d plotter, needs coordinates
        fprintf(output_file, "%d %d\n", rand() %100, rand() % 100);
    }

    //close the file

    fclose(output_file);

    return 0;
}