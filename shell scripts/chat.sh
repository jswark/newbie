#!/bin/bash

echo "enter password"
read password
touch info.txt
openssl enc -aes-256-cbc -k -salt -in info.txt -out info.enc -k password
rm -f info.txt

trap "openssl enc -aes-256-cbc -d -in info.enc -out info.txt -k password | cat info.txt" 8
rm -f info.txt
echo my_pid = $$
echo "enter pid of comp"
read pid

while true 
do
	read text
	openssl enc -aes-256-cbc -d -in info.enc -out info.txt -k password
	echo "$text" > info.txt
	rm -f info.txt
	kill -8 $pid
done
