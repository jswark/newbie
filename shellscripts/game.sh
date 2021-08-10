#!/bin/bash

echo -e 'rock, scissors, paper'

while true
do
echo enter your figure
read figure

rand_figure=$((RANDOM % 3))

choose=$((RANDOM % 100))

if [[ "$choose" -lt "57" ]]; then 
# 0 - rock, 1 - scvizzer, 2 - paper

if [[ "$figure" = "rock" ]] && [[ "$rand_figure" = "2"  ]] ; then 
	echo -e "comp figure is paper \nyou lose"

elif [[ "$figure" = "rock" ]] && [[ "$rand_figure" = "1" ]] ; then 
	echo -e "comp figure is scissors \nyou win"

elif [[ "$figure" = "rock" ]] && [[ ("$rand_figure" = "0" ) ]] ; then 
	echo -e "comp figure is rock \ndraw"

elif [[ "$figure" = "scissors" ]] && [[ "$rand_figure" = "0" ]] ; then
	echo -e "comp figure is rock \nyou lose"

elif [[ "$figure" = "scissors" ]] && [[ "$rand_figure" = "1" ]] ; then
	echo -e "comp figure is scissors \ndraw"

elif [[ "$figure" = "scissors" ]] && [[ "$rand_figure" = "0" ]] ; then
	echo -e "comp figure is rock \nyou lose"

elif [[ "$figure" = "scissors" ]] && [[ "$rand_figure" = "2" ]] ; then
	echo -e "comp figure is paper \nyou win"

elif [[ "$figure" = "paper" ]] && [[ "$rand_figure" = "1" ]] ; then
	echo -e "comp figure is scissors \nyou lose"

elif [[ "$figure" = "paper" ]] && [[ "$rand_figure" = "0" ]] ; then
	echo -e "comp figure is rock \nyou win"

elif [[ "$figure" = "paper" ]] && [[ "$rand_figure" = "2" ]] ; then
	echo -e "comp figure is paper \ndraw"

elif
	[ "$figure" = "exit" ] ; then
	exit

else 
	echo incorrect command
fi


else
	if [[ "$figure" = "rock" ]] ; then 
		echo -e "comp figure is paper \nyou lose"

	elif [[ "$figure" = "paper" ]]  ; then
		echo -e "comp figure is scissors \nyou lose"

	elif [[ "$figure" = "scissors" ]] ; then
		echo -e "comp figure is rock \nyou lose"
	elif
		[ "$figure" = "exit" ] ; then
	exit
	else 
		echo incorrect command
	fi
fi
done 