#include <stdio.h>

struct Point2d {
    int x;
    int y;
};

int main(int argc, char* argv[]){
    if (argc != 2){
        fprintf(stderr, "Usage: %s <file to open>\n", argv[0]);
        return 1;
    }
    //r indicates to read the file
    FILE* input_file = fopen(argv[1], "r");
    if (input_file == NULL){
        fprintf(stderr, "Could not open file %s\n", argv[1]);
        return 1;
    }

    Point2d points[100];
    for(int i = 0; i < 100; ++i){
        //fscanf(filehandler, "format to read", pointers);
        fscanf(input_file, "%d %d\n", points[i].x, points[i].y);
    }

    //loaded all the points, and want to calculate the average of x's and y's 
    Point2d average;
    average.x = 0;
    average.y = 0;
    for(int i = 0; i < 100, ++i){
        average.x += points[i] .x;
        average.y += points[i].y;

    }
    //truncates the floating point numbers
    average.x /= 100;
    average.y /= 100;
    printf("Average: %d %d\n", average.x, average.y);
    //close the file
    fclose(input_file);
    
    return 0;
}