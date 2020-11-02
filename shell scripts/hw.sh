#!/bin/bash

ccode="#include <stdio.h>\n #include <stdlib.h>\n
int main(){ 
FILE *ptr = fopen(\"new.sh\",\"w\"); 
fprintf(ptr, \"%s\", 
		\"ccode=\\\" #include <stdio.h> \\\\\\\\\\\\\\\n 
		int main(){ 
		printf(\\\\\\\\\\\"%s\\\\\\\\\\\",\\\\\\\\\\\"hello world\\\\\\\\\\\");\\\n 
		return 0;}\\\" \\\n 
		touch new.c \\\n 
		echo \$ccode >> new.c \\\n 
		gcc new.c -o new \\\n 
		./new\"); 
fclose(ptr);
system(\"chmod 777 ./new.sh\");
system(\" ./new.sh \");
return 0; } "

touch hw1.c
echo -e $ccode >> hw1.c

gcc hw1.c -o hw1
./hw1

