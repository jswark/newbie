#!/bin/bash

echo -e 'available command: \n copy \n create \n delite \n exit \n move'

while true
do
echo enter command
read command

if [ "$command" = "copy" ] 
then 
	echo enter file for copying
	read filenamecopy
	echo enter file to copy
	read filenamedest
	cp $filenamecopy $filenamedest
	echo done

elif [ "$command" = "create" ]; then
	
	echo enter name for the file 
	read name
	touch $name
	echo done

elif
	[ "$command" = "delite" ]; then
	echo enter name of the file 
	read name
	rm $name
	echo done
elif
	[ "$command" = "move" ]; then
	echo enter name of the file 
	read name
	echo enter name of the folder
	read folder
	mv $name $folder
	echo done
elif
	[ "$command" = "exit" ]; then
	exit

else 
	echo incorrect command
fi
done 
