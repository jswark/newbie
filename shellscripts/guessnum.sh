#!/bin/bash

openssl enc -d -aes-256-cbc -in secret.enc -out secret.txt

echo -e 'guess number'
number=$(cat ./secret.txt)

rm secret.txt

while true
do

echo enter your number
read guess

if [[ "$guess" = "$number" ]] ; then
	echo you win
	exit
elif [[ "$guess" -gt "$number" ]] ; then
	echo take less
elif [[ "$guess" -lt "$number" ]] ; then
	echo take more
elif 
	[[ "$guess" = "exit" ]] ; then
		exit
else 
	echo try again

fi

done

#все файлы со словом линукс в пути